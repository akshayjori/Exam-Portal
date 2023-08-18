package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.controller.wrapper.GetUserName;
import com.cognizant.dao.DB;

@Service
public class GetUserNameService {
	public String showUserName(GetUserName getusername) {

		String username = "";
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			String myQuery = "SELECT username FROM user where contactNo = ? and email = ?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, getusername.getContactNo());
			myStatement.setString(2, getusername.getEmail());
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				username = myResult.getString("username");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return username;
	}

}
