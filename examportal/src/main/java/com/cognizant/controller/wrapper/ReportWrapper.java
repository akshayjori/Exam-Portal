package com.cognizant.controller.wrapper;

public class ReportWrapper {

	private String examCode;
	private int userCount;
	private int noOfPass;
	private int noOfFail;
	private int highestScore;
	public ReportWrapper(String examCode,int userCount, int noOfPass, int noOfFail, int highestScore) {
		super();
		this.userCount = userCount;
		this.noOfPass = noOfPass;
		this.noOfFail = noOfFail;
		this.highestScore = highestScore;
		this.examCode=examCode;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getNoOfPass() {
		return noOfPass;
	}
	public void setNoOfPass(int noOfPass) {
		this.noOfPass = noOfPass;
	}
	public int getNoOfFail() {
		return noOfFail;
	}
	public void setNoOfFail(int noOfFail) {
		this.noOfFail = noOfFail;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	
	
}
