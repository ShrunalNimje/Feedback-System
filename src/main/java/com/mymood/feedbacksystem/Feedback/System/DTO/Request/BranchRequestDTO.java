package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BranchRequestDTO {

	@NotBlank(message = "Branch name must not be blank")
    @Size(min = 2, max = 100, message = "Branch name must be between 2 and 100 characters")
	private String name;
	
	@NotNull(message = "Department ID must be provided")
	private Long departmentId;
	
	public BranchRequestDTO() {
		
	}

	public BranchRequestDTO(String name, Long departmentId) {
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
