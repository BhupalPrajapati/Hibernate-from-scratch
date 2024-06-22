package com.mapping;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

// One to one mapping with the question and answer tabel

@Entity
public class Question {
	@Id
	@Column(name = "question_Id")
	private int questionId;
	private String question;

	
          // take variable for the answer (one to one reationship)
//	@OneToOne
//	private Answer answer;
	
	
	        // OneToMany Relationship 
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;
	

	public int getQuestionId() {
		return questionId;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
