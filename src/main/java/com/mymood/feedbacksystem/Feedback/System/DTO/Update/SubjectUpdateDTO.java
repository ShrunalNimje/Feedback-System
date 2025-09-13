package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class SubjectUpdateDTO {

	@Size(max = 20, message = "Subject code can be up to 20 characters")
    private String subjectCode;    

    @Size(max = 100, message = "Subject name can be up to 100 characters")
    private String subjectName;    

    private SubjectType subjectType;    

    private Long departmentId;    

    @Min(value = 1, message = "Semester must be positive")
    @Max(value = 12, message = "Semester cannot exceed 12")
    private Integer semester; 

	 public SubjectUpdateDTO() {
		 
	 }

	 public SubjectUpdateDTO(String subjectCode, String subjectName, SubjectType subjectType, 
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
