package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.controller.wrapper.UpdatePasswordWrapper;
import com.cognizant.dao.DB;

@Service
public class UpdatePasswordService {

	public boolean checkBothPassword(UpdatePasswordWrapper updatepasswordwrapper) {

		boolean ans = false;
		if (updatepasswordwrapper.getNewpassword().equalsIgnoreCase(updatepasswordwrapper.getConfirmpassword())) {
			ans = true;
		} else {
			ans = false;
		}

		return ans;

	}
	
	public boolean updateNewPassword(UpdatePasswordWrapper updatepasswordwrapper) {
		
		boolean isDone = false;

		PreparedStatement myStatement = null;
		Connection connection = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "UPDATE user SET password = ? WHERE username = ?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, updatepasswordwrapper.getConfirmpassword());
			myStatement.setString(2, updatepasswordwrapper.getUsername());
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
