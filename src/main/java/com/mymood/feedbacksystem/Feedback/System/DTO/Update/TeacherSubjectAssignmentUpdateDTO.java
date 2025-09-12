package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

public class TeacherSubjectAssignmentUpdateDTO {

    private Long teacherId;
    private Long subjectId;
    private Long sectionId;
    private Long batchId;
    private Integer year;
    private Integer semester;

    public TeacherSubjectAssignmentUpdateDTO() {
    	
	}
    
    public TeacherSubjectAssignmentUpdateDTO(Long teacherId, Long subjectId, Long sectionId, Long batchId,
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
