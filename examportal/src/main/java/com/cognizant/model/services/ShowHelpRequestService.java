package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.Ticket;

@Service
public class ShowHelpRequestService {
	
public List <Ticket> getTicketDetails(Ticket ticket) {
		
		List<Ticket> ticketList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT ticketId,userId, ticketDate , typeofissue , description , status ,  adminResponce FROM Tickets WHERE status='NOT RESOLVED'";
			myStatement = connection.prepareStatement(myQuery);
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				Ticket t = new Ticket();
				t.setTicketId(myResult.getInt(1));
				t.setUserId(myResult.getInt(2));
				t.setTicketDate(myResult.getDate(3));
				t.setTypeofissue(myResult.getString(4));
				t.setDescription(myResult.getString(5));
				t.setStatus(myResult.getString(6));
				t.setAdminResponce(myResult.getString(7));
				ticketList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
public List <Ticket> getEachTicketDetails(int ticketId) {
	
	List<Ticket> ticketList = new ArrayList<>();
	Connection connection = null;
	PreparedStatement myStatement = null;
	ResultSet myResult = null;
	try {
		try {
			connection = DB.getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		String myQuery = "SELECT ticketId,userId, ticketDate , typeofissue , description , status ,  adminResponce FROM Tickets WHERE ticketId=?;";
		myStatement = connection.prepareStatement(myQuery); 
		myStatement.setInt(1, ticketId);
		myResult = myStatement.executeQuery();
		while (myResult.next()) {
			Ticket t = new Ticket();
			t.setTicketId(myResult.getInt(1));
			t.setUserId(myResult.getInt(2));
			t.setTicketDate(myResult.getDate(3));
			t.setTypeofissue(myResult.getString(4));
			t.setDescription(myResult.getString(5));
			t.setStatus(myResult.getString(6));
			t.setAdminResponce(myResult.getString(7));
			ticketList.add(t);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ticketList;
}

public boolean solveTicket(Ticket ticket) {
	boolean isDone = false;

	PreparedStatement myStatement = null;
	Connection connection = null;
	try {
		try {
			connection = DB.getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		String myQuery = "UPDATE Tickets SET adminResponce = ? , status = 'RESOLVED' WHERE ticketId = ?;";
		myStatement = connection.prepareStatement(myQuery);
		myStatement.setString(1, ticket.getAdminResponce());
		myStatement.setInt(2 , ticket.getTicketId());
		int rows = myStatement.executeUpdate();
		isDone = (rows == 1) ? true : false;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return isDone;
	
}

	

}
