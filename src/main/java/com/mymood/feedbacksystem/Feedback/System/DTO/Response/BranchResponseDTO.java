package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class BranchResponseDTO {

	private Long branchId;
		
	private String name;
	
	private String departmentName;
	
	public BranchResponseDTO() {
		
	}

	public BranchResponseDTO(Long branchId, String name, String departmentName) {
		this.branchId = branchId;
		this.name = name;
		this.departmentName = departmentName;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
