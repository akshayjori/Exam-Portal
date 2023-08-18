package com.cognizant.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Ticket {

	private int userId;
	private int ticketId;
	private Date ticketDate;
	private String description;
	private String typeofissue;
	private String status;
	private String adminResponce;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminResponce() {
		return adminResponce;
	}

	public void setAdminResponce(String adminResponce) {
		this.adminResponce = adminResponce;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeofissue() {
		return typeofissue;
	}

	public void setTypeofissue(String typeofissue) {
		this.typeofissue = typeofissue;
	}

	public Ticket() {

	}

}
