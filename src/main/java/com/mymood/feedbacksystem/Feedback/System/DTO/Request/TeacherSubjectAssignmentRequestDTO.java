package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TeacherSubjectAssignmentRequestDTO {

	@NotNull(message = "Teacher ID is required")
    private Long teacherId;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;

    @NotNull(message = "Section ID is required")
    private Long sectionId;

    private Long batchId;

    @NotNull(message = "Year is required")
    @Min(value = 1, message = "Year must be at least 1")
    private Integer year;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be at least 1")
    private Integer semester;

    public TeacherSubjectAssignmentRequestDTO() {
    	
	}
    
    public TeacherSubjectAssignmentRequestDTO(Long teacherId, Long subjectId, Long sectionId, Long batchId,
			Integer year, Integer semester) {
		super();
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.sectionId = sectionId;
		this.batchId = batchId;
		this.year = year;
		this.semester = semester;
	}
    
	public Long getTeacherId() {
        return teacherId;
    }
	
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    
    public Long getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    
    public Long getSectionId() {
        return sectionId;
    }
    
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
    
    public Long getBatchId() {
        return batchId;
    }
    
    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public Integer getSemester() {
        return semester;
    }
    
    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
