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
public class AssessmentListServices {

	public static List<AssessDetailsWrapper> getAllAssessments(int userid) {
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

			String myQuery = "select distinct attemptid, examName, examcode, score, attemptdate from examattempts join examDetails using(examCode) where userid=? order by attemptdate desc, attemptid desc;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userid);
			result = myStatement.executeQuery();
			while (result.next()) {
				int attemptId = result.getInt("attemptid");
				String examName= result.getString("examName");
				String examCode = result.getString("examcode");
				int score = result.getInt("score");
				Date attemptDate = result.getDate("attemptdate");
				assessWrapper = new AssessDetailsWrapper(attemptId, examName, examCode, attemptDate, score);
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
