package com.cognizant.model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.cognizant.dao.DB;
import com.cognizant.model.Question;

@Service
public class SearchQuesService{
	
	static public List<Question> showQuestions(String subject){
		Connection connection = null;
		PreparedStatement myStatement = null;
		ResultSet myResult = null;
		List<Question> quesList=new ArrayList<>();
		
		try {
			try {
				connection = DB.getConnection();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		System.out.println("subject=======>>> "+subject);
		String myQuery = "select subject, question, questionId from questionpool where subject like '%"+subject+"%';";
		myStatement = connection.prepareStatement(myQuery);
//		myStatement.setString(1, subject);
		myResult = myStatement.executeQuery();
		
		while(myResult.next()) {
			Question question= new Question();
			question.setSubject(myResult.getString(1));
			question.setQuestion(myResult.getString(2));
			question.setQuestionId(myResult.getInt(3));
			quesList.add(question);
		}
		}	
		catch(Exception e){
			e.printStackTrace();
			}
			
		return quesList;
		}
			
}
	


		
