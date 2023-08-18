package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.controller.wrapper.GenerateReportWrapper;
import com.cognizant.controller.wrapper.ReportWrapper;
import com.cognizant.dao.DB;

@Service
public class GenerateReportService {

	public static List<String> examCodesList() {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		List<String> examCodesList = new ArrayList<>();
		examCodesList.add("All");
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery = "select examcode from examdetails";
			myStatement = connection.prepareStatement(myQuery);
			myResult = myStatement.executeQuery();

			while (myResult.next()) {
				String examCode = myResult.getString("examcode");
				examCodesList.add(examCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return examCodesList;
	}

	static int count;

	public static List<ReportWrapper> report(GenerateReportWrapper wrapper) {
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		List<ReportWrapper> list = new ArrayList<>();

		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String myQuery=null;
			if (wrapper.getExamCode().equals("All")) {
               myQuery="select examcode,count(distinct userid) as userCount,max(score), "
						+ "(select count(distinct userid) from examattempts e2 where score>=40 and "
						+ "e2.examcode=e1.examcode "
						+ ")as noOfPass, (count(distinct userid)-(select count(distinct userid) "
						+ "from examattempts e3 where score>=40 and " + "e3.examcode=e1.examcode)) as noOfFail "
						+ " from examattempts e1 where attemptdate " + "between ifnull(?,'01-01-2000')  "
						+ "and ifnull(?,current_Date()) and examcode!=? group by examcode;";
                
			} else {
				 myQuery = "select examcode,count(distinct userid) as userCount,max(score), "
						+ "(select count(distinct userid) from examattempts e2 where score>=40 and "
						+ "e2.examcode=e1.examcode "
						+ ")as noOfPass, (count(distinct userid)-(select count(distinct userid) "
						+ "from examattempts e3 where score>=40 and " + "e3.examcode=e1.examcode)) as noOfFail "
						+ " from examattempts e1 where attemptdate " + "between ifnull(?,'01-01-2000')  "
						+ "and ifnull(?,current_Date()) and examcode=?;";
			}
				myStatement = connection.prepareStatement(myQuery);
				myStatement.setDate(1, wrapper.getStartDate());
				myStatement.setDate(2, wrapper.getEndDate());
				myStatement.setString(3, wrapper.getExamCode());
				// myStatement.setInt(4, wrapper.getNoOfAttempts());
				myResult = myStatement.executeQuery();

				while (myResult.next()) {
					ReportWrapper wr = new ReportWrapper(myResult.getString(1), myResult.getInt(2), myResult.getInt(4),
							myResult.getInt(5), myResult.getInt(3));
					list.add(wr);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
