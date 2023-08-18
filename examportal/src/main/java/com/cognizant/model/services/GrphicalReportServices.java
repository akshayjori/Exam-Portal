package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;

@Service
public class GrphicalReportServices {

	// gets all ExamAttempts
	public static Map<String, Integer> getAllExamAttempts() {
		Map<String, Integer> attemptsMap = new HashMap<>();
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet result = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			String myQuery = "select t1.subject, count(t1.attemptid) from (select e.subject, a.attemptId from examAttempts a join examdetails e using(examCode) group by a.attemptId) t1 group by t1.subject;";

			myStatement = connection.prepareStatement(myQuery);
			result = myStatement.executeQuery();
			while (result.next()) {
				attemptsMap.put(result.getString(1), result.getInt(2));
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
		return attemptsMap;
	}
}
