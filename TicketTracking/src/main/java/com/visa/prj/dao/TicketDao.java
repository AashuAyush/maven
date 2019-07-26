package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
	@Query ("from Ticket t where raisedByEmail.email = :e")
	List<Ticket> findTickets (@Param ("e") String email);

}
