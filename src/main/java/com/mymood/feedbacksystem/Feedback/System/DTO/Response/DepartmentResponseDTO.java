package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class DepartmentResponseDTO {
	
	private String name;
	
	private Long departmentId;

	public DepartmentResponseDTO() {
		
	}
	
	public DepartmentResponseDTO(Long departmentId, String name) {
		this.departmentId = departmentId;
		this.name = name;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
