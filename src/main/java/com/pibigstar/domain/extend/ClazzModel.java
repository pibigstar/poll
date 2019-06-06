package com.pibigstar.domain.extend;

import com.pibigstar.domain.Entity;
import com.pibigstar.domain.Grade;
import com.pibigstar.domain.User;

public class ClazzModel extends Entity{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String description;
    
    private Grade grade;
    
    private User user;

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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    

}
