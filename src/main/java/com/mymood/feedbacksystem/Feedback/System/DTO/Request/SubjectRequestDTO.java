package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

public class SubjectRequestDTO {

	 private String subjectCode;
	 private String subjectName;
	 private SubjectType subjectType;
	 private Long departmentId;

	 public SubjectRequestDTO() {
		 
	 }

	 public SubjectRequestDTO(String subjectCode, String subjectName, SubjectType subjectType, Long departmentId) {
	     this.subjectCode = subjectCode;
	     this.subjectName = subjectName;
	     this.subjectType = subjectType;
	     this.departmentId = departmentId;
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
