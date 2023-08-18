package com.cognizant.controller.wrapper;

import java.util.List;

import com.cognizant.model.ExamAttemptQuestion;

public class ExamAttemptWrapper {

	private List<ExamAttemptQuestion> examAttemptQuestions;

	public List<ExamAttemptQuestion> getExamAttemptQuestions() {
		return examAttemptQuestions;
	}

	public void setExamAttemptQuestions(List<ExamAttemptQuestion> examAttemptQuestions) {
		this.examAttemptQuestions = examAttemptQuestions;
	}

	public ExamAttemptWrapper() {
		super();
	}

	@Override
	public String toString() {
		return "ExamAttemptWrapper [examAttemptQuestions=" + examAttemptQuestions + "]";
	}
}
