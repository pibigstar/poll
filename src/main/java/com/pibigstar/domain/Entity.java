package com.pibigstar.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Entity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
