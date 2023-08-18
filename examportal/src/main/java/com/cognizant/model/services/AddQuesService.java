package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.Question;

@Service
public class AddQuesService {

	// to insert question in db
	public boolean addQuestion(Question ques) {
		// database connection
		Connection connection = null;
		PreparedStatement myStatement = null;
		int rows = 0;
		boolean isAdded = false;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "Insert into questionpool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) values(?,?,?,?,?,?,?,?,?);";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, ques.getQuestion());
			myStatement.setString(2, ques.getOptionA());
			myStatement.setString(3, ques.getOptionB());
			myStatement.setString(4, ques.getOptionC());
			myStatement.setString(5, ques.getOptionD());
			myStatement.setString(6, ques.getAnswer());
			myStatement.setString(7, ques.getCompetency());
			myStatement.setInt(8, ques.getMarks());
			myStatement.setString(9, ques.getSubject());

			rows = myStatement.executeUpdate();
			isAdded = (rows == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isAdded;
	}

	// checks if question already exists
	public boolean chechIfQuestionExists(Question ques) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet result = null;
		boolean isExists = false;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "select question from questionpool where question= ?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, ques.getQuestion());

			result = myStatement.executeQuery();
			if (result.next()) {
				isExists = true;
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
		return isExists;
	}

}
