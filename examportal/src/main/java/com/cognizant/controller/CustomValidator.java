package com.cognizant.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.dao.DB;
import com.cognizant.model.User;

@Service
public class CustomValidator implements Validator {

	
	public void validate(Object arg0, Errors arg1) {
		User user = (User) arg0;
		String rUsername="";
		String rPassword="";

		//database connection
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT username, password FROM user WHERE username=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, user.getUsername());
			myResult= myStatement.executeQuery();
			myResult.next();
			rUsername= myResult.getString(1);
			rPassword= myResult.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//if UserId doen't exist in database
		if(!user.getUsername().equals(rUsername)) {
			arg1.rejectValue("username", "", "No user with this UserId");
		}
		
		//if userId exists but password id incorrect
        if(user.getUsername().equals(rUsername) && !user.getPassword().equals(rPassword)) {
			arg1.rejectValue("password", "", "Wrong password!!!");
		}

	}

	public boolean supports(Class<?> arg0) {
		return false;
	}

}