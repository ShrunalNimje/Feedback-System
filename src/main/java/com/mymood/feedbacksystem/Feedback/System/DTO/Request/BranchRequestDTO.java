package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class BranchRequestDTO {

	private String name;
	
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
