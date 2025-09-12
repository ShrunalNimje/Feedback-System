package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.Size;

public class BranchUpdateDTO {

    @Size(min = 2, max = 100, message = "Branch name must be between 2 and 100 characters")
	private String name;
	
	private Long departmentId;
	
	public BranchUpdateDTO() {
		
	}

	public BranchUpdateDTO(String name, Long departmentId) {
		this.name = name;
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
}
