package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FeedbackRequestDTO {

	@NotNull(message = "Teacher ID is required")
    private Long teacherId;

    @NotNull(message = "Enrollment ID is required")
    private String enrollmentId;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;

    @NotNull(message = "Semester is required")
    private Integer semester;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;

    @NotNull(message = "Question 1 rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private Integer question1Rating;

    @NotNull(message = "Question 2 rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private Integer question2Rating;

    @NotNull(message = "Question 3 rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private Integer question3Rating;

    @NotNull(message = "Question 4 rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private Integer question4Rating;

    @NotNull(message = "Question 5 rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private Integer question5Rating;

    public FeedbackRequestDTO() {
    }

    public FeedbackRequestDTO(Long teacherId, String enrollmentId, Long subjectId, Integer semester,
                              Double latitude, Double longitude,
                              Integer question1Rating, Integer question2Rating,
                              Integer question3Rating, Integer question4Rating,
                              Integer question5Rating) {
        this.teacherId = teacherId;
        this.enrollmentId = enrollmentId;
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

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
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
