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
public class UserHelpService {
	
	public boolean reportIssue(Ticket ticket) {
		
		boolean isReported = false;
		
		PreparedStatement myStatement = null;
		Connection connection = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "INSERT INTO Tickets (userId,typeofissue,description) VALUES(?,?,?);";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, ticket.getUserId());
			myStatement.setString(2, ticket.getTypeofissue());
			myStatement.setString(3, ticket.getDescription());
			int rows = myStatement.executeUpdate();
			isReported = (rows == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isReported;
		
	}
	
	public List <Ticket> getTicketDetails(int userId) {
		
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
			String myQuery = "SELECT ticketId, ticketDate , description , typeofissue , status ,  adminResponce FROM Tickets WHERE userId=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userId);
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				Ticket t = new Ticket();
				t.setTicketId(myResult.getInt(1));
				t.setTicketDate(myResult.getDate(2));
				t.setDescription(myResult.getString(3));
				t.setTypeofissue(myResult.getString(4));
				t.setStatus(myResult.getString(5));
				t.setAdminResponce(myResult.getString(6));
				ticketList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
	

}
