package com.cognizant.controller.wrapper;

public class GenerateReportWrapper {

	
	private String examCode;
	private java.sql.Date startDate;
	private java.sql.Date endDate;

	
	
	
	
	@Override
	public String toString() {
		return "GenerateReportWrapper [examCode=" + examCode + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public java.sql.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	
	
}
