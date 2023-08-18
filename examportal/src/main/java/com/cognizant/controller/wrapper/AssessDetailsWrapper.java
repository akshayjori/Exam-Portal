package com.cognizant.controller.wrapper;

import java.util.Date;

public class AssessDetailsWrapper {

	private int attemptId;
	private String examName;
	private String examCode;
	private Date attemptDate;
	private int score;
	private String feedback;

	public AssessDetailsWrapper(int attemptId, String examCode, Date attemptDate, int score, String feedback) {
		super();
		this.attemptId = attemptId;
		this.examCode = examCode;
		this.attemptDate = attemptDate;
		this.score = score;
		this.feedback = feedback;
	}

	public AssessDetailsWrapper(int attemptId2, String examName, String examCode2, Date attemptDate2, int score2) {
		this.attemptId= attemptId2;
		this.examName= examName;
		this.examCode = examCode2;
		this.attemptDate = attemptDate2;
		this.score = score2;
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Date getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

}
