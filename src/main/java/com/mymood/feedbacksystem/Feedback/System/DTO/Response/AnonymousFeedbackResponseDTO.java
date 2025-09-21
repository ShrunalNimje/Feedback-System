package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import java.time.LocalDateTime;

public class AnonymousFeedbackResponseDTO {

    private Long feedbackId;
    private String teacherName;
    private String subjectName;
    private Integer semester;
    private LocalDateTime submittedAt;

    public AnonymousFeedbackResponseDTO() {
    	
    }

    public AnonymousFeedbackResponseDTO(Long feedbackId, String teacherName, String subjectName, 
    		Integer semester, LocalDateTime submittedAt) {
        this.feedbackId = feedbackId;
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.semester = semester;
        this.submittedAt = submittedAt;
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
}
