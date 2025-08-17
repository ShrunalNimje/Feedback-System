package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import java.time.LocalDateTime;

public class FeedbackResponseDTO {

    private Long feedbackId;
    private String teacherName;
    private String studentName;
    private String subjectName;
    private Integer semester;
    private LocalDateTime submittedAt;

    public FeedbackResponseDTO() {
    	
    }

    public FeedbackResponseDTO(Long feedbackId, String teacherName, String studentName,
                               String subjectName, Integer semester, LocalDateTime submittedAt) {
        this.feedbackId = feedbackId;
        this.teacherName = teacherName;
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
