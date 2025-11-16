package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import java.time.LocalDateTime;

public class AnonymousFeedbackResponseDTO {

    private Long feedbackId;
    private String teacherName;
    private String subjectName;
//    private Long subjectId;
//    private Long batchId;
//    private Long sectionId;
    private Integer semester;
    private LocalDateTime submittedAt;

    public AnonymousFeedbackResponseDTO() {
    	
    }

    public AnonymousFeedbackResponseDTO(Long feedbackId, String teacherName, String subjectName, 
    		Integer semester, LocalDateTime submittedAt /*, Long subjectId, Long batchId, Long sectionId*/) {
        this.feedbackId = feedbackId;
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.semester = semester;
        this.submittedAt = submittedAt;
//        this.subjectId = subjectId;
//        this.batchId = batchId;
//        this.sectionId = sectionId;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

//	public Long getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(Long subjectId) {
//		this.subjectId = subjectId;
//	}
//
//	public Long getBatchId() {
//		return batchId;
//	}
//
//	public void setBatchId(Long batchId) {
//		this.batchId = batchId;
//	}
//
//	public Long getSectionId() {
//		return sectionId;
//	}
//
//	public void setSectionId(Long sectionId) {
//		this.sectionId = sectionId;
//	}
    
}
