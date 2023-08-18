package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.Exam;

@Service
public class ExamService {

	// to insert new exam details into database
	public boolean addExamDetails(Exam exam) {
		boolean isDone = false;

		PreparedStatement myStatement = null;
		Connection connection = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "INSERT INTO examdetails VALUES(?, ?, ?, ?);";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, exam.getExamCode());
			myStatement.setString(2, exam.getExamName());
			myStatement.setString(3, exam.getSubject());
			myStatement.setString(4, exam.getCompetency());
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

	// to check for existing examcode
	public boolean checkForExistingExamCode(Exam exam) {
		String rExamCode = null;
		boolean isExamCodePresent = false;

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT examName FROM examdetails WHERE examcode= ?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, exam.getExamCode());
			myResult = myStatement.executeQuery();
			myResult.next();
			rExamCode = myResult.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rExamCode != null) {
			isExamCodePresent = true;
		}
		return isExamCodePresent;
	}

	// searches for exams by search word and returns array of them
	public ArrayList<Exam> searchExams(String searchWord) {
		ArrayList<Exam> examsList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT examcode, examName, subject, competency FROM ExamDetails where examName like '%"
					+ searchWord + "%' or examcode=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, searchWord);
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				Exam exam = new Exam();
				exam.setExamCode(myResult.getString(1));
				exam.setExamName(myResult.getString(2));
				exam.setSubject(myResult.getString(3));
				exam.setCompetency(myResult.getString(4));
				examsList.add(exam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return examsList;
	}

}
