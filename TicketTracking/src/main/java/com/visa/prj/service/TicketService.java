package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.Update;
import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public void raiseTicket(Ticket t) {
		ticketDao.save(t);
	}
	
	public List<Ticket> getTickets (String email){
		return ticketDao.findTickets(email);
	}
	
	public Ticket getTicket (int ticketId) {
		return ticketDao.findById(ticketId).get();
	}
	
	@Transactional
	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}
	
	@Transactional
	public void resolveTicket(Update update) {
		Employee e = employeeDao.findByEmail(update.getEmail());
		System.out.println(e.toString());
		if (e.getRole().contentEquals("IT")) {
			Ticket t = ticketDao.findById(update.getTicketId()).get();
			t.setResolvedByEmail(employeeDao.findByEmail(update.getEmail()));
			t.setResolvedDate(update.getResolvedDate());
			t.setResolvedInfo(update.getResolvedInfo());
			t.setResolved(true);
			ticketDao.save(t);
		}
	}
}
