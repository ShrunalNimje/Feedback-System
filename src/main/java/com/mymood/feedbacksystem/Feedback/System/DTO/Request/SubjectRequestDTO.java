package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubjectRequestDTO {

	@NotBlank(message = "Subject code is required")
    private String subjectCode;

    @NotBlank(message = "Subject name is required")
    private String subjectName;

    @NotNull(message = "Subject type is required")
    private SubjectType subjectType;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester should be at least 1")
    private Integer semester;

	 public SubjectRequestDTO() {
		 
	 }

	 public SubjectRequestDTO(String subjectCode, String subjectName, SubjectType subjectType, 
			 Long departmentId, Integer semester) {
	     this.subjectCode = subjectCode;
	     this.subjectName = subjectName;
	     this.subjectType = subjectType;
	     this.departmentId = departmentId;
	     this.semester = semester;
	 }
	
	 public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getSubjectCode() {
	     return subjectCode;
	 }
	
	 public void setSubjectCode(String subjectCode) {
	     this.subjectCode = subjectCode;
	 }
	
	 public String getSubjectName() {
	     return subjectName;
	 }
	
	 public void setSubjectName(String subjectName) {
	     this.subjectName = subjectName;
	 }
	
	 public SubjectType getSubjectType() {
	     return subjectType;
	 }
	
	 public void setSubjectType(SubjectType subjectType) {
	     this.subjectType = subjectType;
	 }
	
	 public Long getDepartmentId() {
	     return departmentId;
	 }
	
	 public void setDepartmentId(Long departmentId) {
	     this.departmentId = departmentId;
	 }
}
