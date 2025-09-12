package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.Size;

public class DepartmentUpdateDTO {
	
    @Size(min = 2, max = 100, message = "Department name must be between 2 and 100 characters")
	private String name;

	public DepartmentUpdateDTO() {
		
	}
	
	public DepartmentUpdateDTO(String name) {
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
