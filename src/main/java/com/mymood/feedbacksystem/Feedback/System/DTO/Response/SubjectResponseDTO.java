package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

public class SubjectResponseDTO {

    private Long subjectId;
    private String subjectCode;
    private String subjectName;
    private SubjectType subjectType;
    private String departmentName;

    public SubjectResponseDTO() {
    	
    }

    public SubjectResponseDTO(Long subjectId, String subjectCode, String subjectName, SubjectType subjectType, String departmentName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.departmentName = departmentName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
