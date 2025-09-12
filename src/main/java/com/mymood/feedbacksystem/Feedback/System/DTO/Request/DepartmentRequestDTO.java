package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentRequestDTO {
	
	@NotBlank(message = "Department name must not be blank")
    @Size(min = 2, max = 100, message = "Department name must be between 2 and 100 characters")
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
