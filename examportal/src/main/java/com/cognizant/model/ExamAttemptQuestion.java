package com.cognizant.model;

import java.util.Date;

public class ExamAttemptQuestion {

	private int attemptId;
	private String examCode;
	private int userId;
	private int questionId;
	private String answer;
	private String response;
	private int marks;
	private String responseStatus;
	private boolean isCorrect;
	private int score;
	private Date attemptDate;
	
	public ExamAttemptQuestion() {
		super();
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String responce) {
		this.response = responce;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responceStatus) {
		this.responseStatus = responceStatus;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	
	@Override
	public String toString() {
		return "ExamAttemptQuestion [attemptId=" + attemptId + ", examCode=" + examCode + ", userId=" + userId
				+ ", questionId=" + questionId + ", answer=" + answer + ", responce=" + response + ", responceStatus="
				+ responseStatus + ", isCorrect=" + isCorrect + "]";
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}
}
