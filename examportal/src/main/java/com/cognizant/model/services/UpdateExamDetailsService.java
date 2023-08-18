package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DB;
import com.cognizant.model.Exam;

@Service
public class UpdateExamDetailsService {

	public static boolean deleteExam(Exam exam) {
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
			String myQuery = "delete from examdetails where examcode= ?;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, exam.getExamCode());

			rows = myStatement.executeUpdate();
			isDeleted = (rows == 1) ? true : false;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
		
	}
	
	
	//update exam details in database
	public static boolean updateExamDetails(Exam exam, String oldExamCode) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		int rows = 0;
		boolean isUpdated = false;
		System.out.println("In updateService OldExamCode========>>>> "+oldExamCode);
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "update examdetails set examcode=?,examName=?,subject=?,competency=?"
					+ " where examcode=?;";

			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, exam.getExamCode());
			myStatement.setString(2, exam.getExamName());
			myStatement.setString(3, exam.getSubject());
			myStatement.setString(4, exam.getCompetency());
			myStatement.setString(5, oldExamCode);
			
			rows = myStatement.executeUpdate();
			isUpdated = (rows == 1) ? true : false;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	
	//get Exam from examcode
	public static Exam showSelectedExamDetails(String examcode) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		Exam examOld = null;
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "select * from examdetails where examcode=?;";
			myStatement = connection.prepareStatement(myQuery);
			myStatement.setString(1, examcode);
			myResult = myStatement.executeQuery();

			myResult.next();
			String examCode = myResult.getString("examcode");
			String examname = myResult.getString("examname");
			String subject = myResult.getString("subject");
			String competency = myResult.getString("competency");

			examOld = new Exam(examCode,examname,subject,competency);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return examOld;
	}

	}
	
	


