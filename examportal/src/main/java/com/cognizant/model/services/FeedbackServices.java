package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;

@Service
public class FeedbackServices {

	// populate Feedback table with attemptId
	public static boolean insertAttemptIdToFeedbackTable(int attemptId) {
		boolean isDone = false;

		PreparedStatement myStatement = null;
		Connection connection = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "INSERT INTO UserFeedback(attemptId) VALUES(?);";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, attemptId);
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

	// add feedback with attemptId
	public static boolean addFeedback(int attemptId, String feedback) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		int rows = 0;
		boolean isUpdated = false;

		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "update UserFeedback set feedback=?, notified= true where attemptId= ?;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, feedback);
			myStatement.setInt(2, attemptId);

			rows = myStatement.executeUpdate();
			isUpdated = (rows == 1) ? true : false;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	// checks for recent examAttemt and returns the same
	public static String checkForRecentAssessment(int userId) {
		String examCode = null;

		PreparedStatement myStatement = null;
		Connection connection = null;
		ResultSet result = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "select examCode from ExamAttempts e join UserFeedback f using(attemptId) where userId=? and feedback is null and DATEDIFF(now(), attemptDate) <= 1 group by attemptid;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userId);
			result = myStatement.executeQuery();
			result.next();
			examCode= result.getString("examCode");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return examCode;

	}
}
