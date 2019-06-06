package com.pibigstar.domain.extend;

import java.util.List;

import com.pibigstar.domain.Entity;

public class QuestionnaireModel extends Entity{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String description;
    
    private List<QuestionModel> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<QuestionModel> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
    
}
