package com.cognizant.controller.wrapper;

public class SearchQuestionsWrapper {

	private String subject;

	public SearchQuestionsWrapper(String subject) {
		this.subject = subject;
	}

	public SearchQuestionsWrapper() {
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
