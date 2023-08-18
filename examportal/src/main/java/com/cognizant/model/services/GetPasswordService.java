package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.controller.wrapper.GetPassword;
import com.cognizant.dao.DB;

@Service
public class GetPasswordService {

	public boolean getPassWord(GetPassword getpassword) {

		boolean ans = false;
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			String myQuery = "SELECT * FROM user where username = ? and contactNo = ? and email = ?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, getpassword.getUsername());
			myStatement.setString(2, getpassword.getContactNo());
			myStatement.setString(3, getpassword.getEmail());
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				ans = true;
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

		return ans;
	}

}
