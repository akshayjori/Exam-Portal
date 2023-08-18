package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.ExamAttemptQuestion;

@Service
public class ExamAttemptServices {
	
	//inserts Exam Attempt data to database
	public boolean insertExamAttempt(ExamAttemptQuestion ex) {
		
		boolean isInserted = false;
		Connection connection = null;
		PreparedStatement myStatement = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String myQuery = "insert into examAttempts(attemptId, examCode, userId, questionId, answer, marks, response, responseStatus, isCorrect, score, attemptDate)"
						   + " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, curdate() );";
			
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, ex.getAttemptId());
			myStatement.setString(2, ex.getExamCode());
			myStatement.setInt(3, ex.getUserId());
			myStatement.setInt(4, ex.getQuestionId());
			myStatement.setString(5, ex.getAnswer());
			myStatement.setInt(6, ex.getMarks());
			myStatement.setString(7, ex.getResponse());
			myStatement.setString(8, ex.getResponseStatus());
			myStatement.setBoolean(9, ex.getIsCorrect());
			myStatement.setInt(10, ex.getScore());
			
			int rows = myStatement.executeUpdate();
			isInserted = (rows == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isInserted;
	}

	//gets the highest attempt id and increases it by 1
	public int getAttemptId() {
		int attemptId=0;
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet result= null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String myQuery = "select MAX(attemptId)+1 from examAttempts";
			myStatement = connection.prepareStatement(myQuery);
			result = myStatement.executeQuery();
			result.next();
			attemptId= result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return attemptId;
	}

}
