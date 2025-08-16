package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class DepartmentRequestDTO {
	
	private String name;

	public DepartmentRequestDTO() {
		
	}
	
	public DepartmentRequestDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
