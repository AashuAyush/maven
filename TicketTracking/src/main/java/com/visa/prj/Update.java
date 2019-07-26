package com.visa.prj;

import java.util.Date;

public class Update {

	private int ticketId;
	private String email;
	private Date resolvedDate;
	private String resolvedInfo;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
