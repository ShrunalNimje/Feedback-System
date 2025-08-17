package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class FeedbackRequestDTO {

    private Long teacherId;
    private Long studentId;
    private Long subjectId;
    private Integer semester;
    private Double latitude;
    private Double longitude;

    private Integer question1Rating;
    private Integer question2Rating;
    private Integer question3Rating;
    private Integer question4Rating;
    private Integer question5Rating;

    public FeedbackRequestDTO() {
    }

    public FeedbackRequestDTO(Long teacherId, Long studentId, Long subjectId, Integer semester,
                              Double latitude, Double longitude,
                              Integer question1Rating, Integer question2Rating,
                              Integer question3Rating, Integer question4Rating,
                              Integer question5Rating) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.semester = semester;
        this.latitude = latitude;
        this.longitude = longitude;
        this.question1Rating = question1Rating;
        this.question2Rating = question2Rating;
        this.question3Rating = question3Rating;
        this.question4Rating = question4Rating;
        this.question5Rating = question5Rating;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getQuestion1Rating() {
        return question1Rating;
    }

    public void setQuestion1Rating(Integer question1Rating) {
        this.question1Rating = question1Rating;
    }

    public Integer getQuestion2Rating() {
        return question2Rating;
    }

    public void setQuestion2Rating(Integer question2Rating) {
        this.question2Rating = question2Rating;
    }

    public Integer getQuestion3Rating() {
        return question3Rating;
    }

    public void setQuestion3Rating(Integer question3Rating) {
        this.question3Rating = question3Rating;
    }

    public Integer getQuestion4Rating() {
        return question4Rating;
    }

    public void setQuestion4Rating(Integer question4Rating) {
        this.question4Rating = question4Rating;
    }

    public Integer getQuestion5Rating() {
        return question5Rating;
    }

    public void setQuestion5Rating(Integer question5Rating) {
        this.question5Rating = question5Rating;
    }
}
