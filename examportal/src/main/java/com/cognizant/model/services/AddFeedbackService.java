package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.cognizant.controller.wrapper.AssessDetailsWrapper;
import com.cognizant.dao.DB;

@Service
public class AddFeedbackService {

	public static boolean addFeedback(int attemptId, String feedback) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		int rows = 0;
		boolean isSubmitted = false;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "update UserFeedback set feedback=? where attemptid=?;";
			myStatement = connection.prepareStatement(myQuery);

			myStatement.setString(1, feedback);
			myStatement.setInt(2, attemptId);

			rows = myStatement.executeUpdate();
			isSubmitted = (rows > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isSubmitted;
	}

	public static List<AssessDetailsWrapper> showGivenFeedbacks(int userid) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet result = null;
		AssessDetailsWrapper assessWrapper = null;
		List<AssessDetailsWrapper> list = new ArrayList<>();
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			String myQuery = "select distinct attemptid, examcode, score, attemptdate, feedback from examattempts join UserFeedback using(attemptId) where userid=? and feedback is not null order by attemptid desc;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userid);
			result = myStatement.executeQuery();
			while (result.next()) {
				int attemptId = result.getInt("attemptid");
				String examCode = result.getString("examcode");
				int score = result.getInt("score");
				Date attemptDate = result.getDate("attemptdate");
				String feedback = result.getString("feedback");
				assessWrapper = new AssessDetailsWrapper(attemptId, examCode, attemptDate, score, feedback);
				list.add(assessWrapper);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection!=null) {
				try {
					myStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return list;
	}

	// gives array of assessment details
	public static List<AssessDetailsWrapper> showAssessments(int userid) {

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet result = null;
		AssessDetailsWrapper assessWrapper = null;
		List<AssessDetailsWrapper> list = new ArrayList<>();
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			String myQuery = "select distinct attemptid, examcode, score,attemptdate from examattempts join UserFeedback using(attemptId) where userid=? and feedback is null order by attemptid desc;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userid);
			result = myStatement.executeQuery();
			while (result.next()) {
				int attemptId = result.getInt("attemptid");
				String examCode = result.getString("examcode");
				int score = result.getInt("score");
				Date attemptDate = result.getDate("attemptdate");
				assessWrapper = new AssessDetailsWrapper(attemptId, examCode, attemptDate, score, null);
				list.add(assessWrapper);

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

		return list;

	}
}
