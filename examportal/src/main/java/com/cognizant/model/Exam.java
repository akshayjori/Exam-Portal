package com.cognizant.model;

import org.springframework.stereotype.Component;

@Component
public class Exam {

	private String examCode;
	private String examName;
	private String subject;

	@Override
	public String toString() {
		return "Exam [examCode=" + examCode + " examName=" + examName + " subject=" + subject + " competency="
				+ competency + "]";
	}

	private String competency;

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examcode) {
		this.examCode = examcode;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String compentency) {
		this.competency = compentency;
	}

	public Exam(String examCode, String examName, String subject, String competency) {
		super();
		this.examCode = examCode;
		this.examName = examName;
		this.subject = subject;
		this.competency = competency;
	}

	public Exam() {
		super();
	}

}
