package com.visa.prj.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tickets")
public class Ticket {

	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int ticketId;
	
	public String ticketDescription;
	
	@Temporal (value = TemporalType.DATE)
	public Date ticketRaiseDate;
	
	@ManyToOne
	@JoinColumn (name = "raisor_email")
	public Employee raisedByEmail;
	
	boolean isResolved;

	@ManyToOne
	@JoinColumn (name = "resolver_email")
	public Employee resolvedByEmail;
	
	@Temporal (value = TemporalType.DATE)
	public Date resolvedDate;
	
	public String resolvedInfo;
	
	public Ticket() {
		Calendar calendar = Calendar.getInstance();
		setTicketRaiseDate(calendar.getTime());
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public Date getTicketRaiseDate() {
		return ticketRaiseDate;
	}

	public void setTicketRaiseDate(Date ticketRaiseDate) {
		this.ticketRaiseDate = ticketRaiseDate;
	}

	public Employee getRaisedByEmail() {
		return raisedByEmail;
	}

	public void setRaisedByEmail(Employee raisedByEmail) {
		this.raisedByEmail = raisedByEmail;
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public Employee getResolvedByEmail() {
		return resolvedByEmail;
	}

	public void setResolvedByEmail(Employee resolvedByEmail) {
		this.resolvedByEmail = resolvedByEmail;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolvedInfo() {
		return resolvedInfo;
	}

	public void setResolvedInfo(String resolvedInfo) {
		this.resolvedInfo = resolvedInfo;
	}
	
	
}
