package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.Exam;
import com.cognizant.model.ExamAttemptQuestion;
import com.cognizant.model.Question;
import com.cognizant.model.User;

@Service
public class Util {

	// get User details by userId
	public static User getUserById(int userId) {
		User returnUser = new User();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT * FROM user WHERE userId= ?";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, userId);
			myResult = myStatement.executeQuery();
			myResult.next();
			returnUser.setUserId(myResult.getInt("userId"));
			returnUser.setFirstname(myResult.getString("firstname"));
			returnUser.setLastname(myResult.getString("lastname"));
			returnUser.setDateOfBirth(myResult.getString("dateOfBirth"));
			returnUser.setGender(myResult.getString("gender"));
			returnUser.setContactNo(myResult.getString("contactNo"));
			returnUser.setEmail(myResult.getString("email"));
			returnUser.setUsername(myResult.getString("username"));
			returnUser.setPassword(myResult.getString("password"));
			returnUser.setAdminAccess(myResult.getBoolean("adminAccess"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnUser;
	}

	// get examDetails by examCode
	public static Exam getExamDetails(String examCode) {
		Exam exam = new Exam();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT examcode, examName, subject, competency FROM ExamDetails where examcode=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, examCode);
			myResult = myStatement.executeQuery();
			myResult.next();
			exam.setExamCode(myResult.getString(1));
			exam.setExamName(myResult.getString(2));
			exam.setSubject(myResult.getString(3));
			exam.setCompetency(myResult.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exam;
	}

	// get Exam Attempt details by AttemptId
	public static ExamAttemptQuestion getExamAttemptQByAttemptId(int attemptId) {
		ExamAttemptQuestion exQuestion = new ExamAttemptQuestion();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT * FROM examAttempts WHERE attemptId= ? limit 1";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setInt(1, attemptId);
			myResult = myStatement.executeQuery();
			myResult.next();
			exQuestion.setAttemptId(myResult.getInt("attemptId"));
			exQuestion.setExamCode(myResult.getString("examCode"));
			exQuestion.setUserId(myResult.getInt("userId"));
			exQuestion.setQuestionId(myResult.getInt("questionId"));
			exQuestion.setAnswer(myResult.getString("answer"));
			exQuestion.setResponse(myResult.getString("response"));
			exQuestion.setMarks(myResult.getInt("marks"));
			exQuestion.setResponseStatus(myResult.getString("responseStatus"));
			exQuestion.setIsCorrect(myResult.getBoolean("isCorrect"));
			exQuestion.setScore(myResult.getInt("score"));
			exQuestion.setAttemptDate(new Date(myResult.getDate("attemptDate").getTime()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exQuestion;
	}

	// to get all subjects from database as array
	public static List<String> getSubjectsArray() {
		List<String> subjectsArray = new ArrayList<>();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT subjectName FROM subjects;";
			myStatement = connection.prepareStatement(myQuery);
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				subjectsArray.add(myResult.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subjectsArray;
	}

	// returns questions to display on examination page
	public static List<Question> getQuestionsByExamCode(String examCode) {
		List<Question> ExamQuestionsList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "SELECT questionId, question, optionA, optionB, optionC, optionD, answer, marks FROM questionpool q join examdetails e on q.subject=e.subject where e.examcode= \'"
					+ examCode + "\' and q.competency= e.competency order by rand() limit 10;";
			myStatement = connection.prepareStatement(myQuery);
			System.out.println("ExamCode in SQL =========> " + examCode);
//			myStatement.setString(1, examCode);
			myResult = myStatement.executeQuery();
			while (myResult.next()) {
				Question exQuestion = new Question();
				exQuestion.setQuestionId(myResult.getInt("questionId"));
				exQuestion.setQuestion(myResult.getString("question"));
				exQuestion.setOptionA(myResult.getString("optionA"));
				exQuestion.setOptionB(myResult.getString("optionB"));
				exQuestion.setOptionC(myResult.getString("optionC"));
				exQuestion.setOptionD(myResult.getString("optionD"));
				exQuestion.setAnswer(myResult.getString("answer"));
				exQuestion.setMarks(myResult.getInt("marks"));
				ExamQuestionsList.add(exQuestion);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ExamQuestionsList;
	}

	// converts browser date string to sql date
	public static java.sql.Date stringToSqlDateConverter(String sDate) {
		Date utDate = null;
		System.out.println("==========> sDate: " + sDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			utDate = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		System.out.println("==========> utilDate: " + utDate);
		java.sql.Date sqlDate;
		String s = new SimpleDateFormat("yyyy-MM-dd").format(utDate);
//		System.out.println("==========> dateString: " + utDate);
		sqlDate = java.sql.Date.valueOf(s);
//		System.out.println("==========> sqlDate: " + sqlDate);
		return sqlDate;
	}

	// converts browser date string to sql date
	public static String utilDateToString(Date utDate) {
		return new SimpleDateFormat("dd-MM-yyyy").format(utDate);
	}
}
