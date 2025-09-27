package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class TeacherSubjectAssignmentResponseDTO {

    private Long teacherSubjectAssignmentId;
    private Long teacherId;
    private Long subjectId;
    private Long sectionId;
    private Long batchId;
    private Integer semester;

    public TeacherSubjectAssignmentResponseDTO() {
    	
	}
    
    public TeacherSubjectAssignmentResponseDTO(Long teacherSubjectAssignmentId, Long teacherId, Long subjectId,
			Long sectionId, Long batchId, Integer semester) {
		super();
		this.teacherSubjectAssignmentId = teacherSubjectAssignmentId;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.sectionId = sectionId;
		this.batchId = batchId;
		this.semester = semester;
	}

	public Long getTeacherSubjectAssignmentId() {
        return teacherSubjectAssignmentId;
    }
    
    public void setTeacherSubjectAssignmentId(Long teacherSubjectAssignmentId) {
        this.teacherSubjectAssignmentId = teacherSubjectAssignmentId;
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
    
    public Integer getSemester() {
        return semester;
    }
    
    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}