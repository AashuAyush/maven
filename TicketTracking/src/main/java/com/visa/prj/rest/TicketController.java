package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.Update;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

@RestController
public class TicketController {
	@Autowired
	private TicketService service;
	
	@GetMapping ("tickets")
	public @ResponseBody List<Ticket> getTickets(@RequestParam (name = "email", required = true) String email){
		return service.getTickets(email);
	}
	
	@PostMapping ("/raiseticket")
	public ResponseEntity<Ticket> addTicket (@RequestBody Ticket t){
		service.raiseTicket(t);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	
	@PostMapping ("resolvetickets")
	public ResponseEntity<Ticket> resolveTicket (@RequestBody Update update){
		service.resolveTicket(update);
		return new ResponseEntity<> (service.getTicket(update.getTicketId()), HttpStatus.OK);
	}
}
