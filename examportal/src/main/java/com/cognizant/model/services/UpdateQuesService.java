package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.cognizant.dao.DB;
import com.cognizant.model.Question;

@Service
public class UpdateQuesService {

	// For Search Questions Page
	public static Question showSelectedQuesDetails(int questionId) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		Question quesOld = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "select * from questionpool where questionId=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, questionId);
			myResult = myStatement.executeQuery();

			myResult.next();
			String question = myResult.getString("question");
			String optionA = myResult.getString("optionA");
			String optionB = myResult.getString("optionB");
			String optionC = myResult.getString("optionC");
			String optionD = myResult.getString("optionD");
			String answer = myResult.getString("answer");
			String competency = myResult.getString("competency");
			int marks = myResult.getInt("marks");
			String subject = myResult.getString("subject");

			quesOld = new Question(questionId, question, optionA, optionB, optionC, optionD, answer, competency, marks,
					subject);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return quesOld;
	}

	
	// Update existing questions
	public static boolean updateSelectedQuesDetails(Question ques) {
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
			String myQuery = "update questionpool set question=?, optionA=?, optionB=?, optionC=?, optionD=?, "
					+ "answer=?, competency=?, marks=? where questionId= ?;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, ques.getQuestion());
			myStatement.setString(2, ques.getOptionA());
			myStatement.setString(3, ques.getOptionB());
			myStatement.setString(4, ques.getOptionC());
			myStatement.setString(5, ques.getOptionD());
			myStatement.setString(6, ques.getAnswer());
			myStatement.setString(7, ques.getCompetency());
			myStatement.setInt(8, ques.getMarks());
			myStatement.setInt(9, ques.getQuestionId());

			rows = myStatement.executeUpdate();
			isUpdated = (rows == 1) ? true : false;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	
	//deletes question and returns true if successful
	public static boolean deleteQuestion(Question ques) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		int rows = 0;
		boolean isDeleted = false;

		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "delete from questionpool where questionId= ?;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, ques.getQuestionId());

			rows = myStatement.executeUpdate();
			isDeleted = (rows == 1) ? true : false;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
}
