package com.mymood.feedbacksystem.Feedback.System.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "feedbacks")
public class FeedbackEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	
	private TeacherEntity teacher;
	
	private StudentEntity student;
	
	private SubjectEntity subject;
	
	@Column(nullable = false)
	private Integer semester;
	
	@Column(nullable = false)
	private Double lat;
	
	@Column(nullable = false)
	private Double lng;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private Integer question1_rating;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private Integer question2_rating;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private Integer question3_rating;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private Integer question4_rating;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private Integer question5_rating;
	
	@CreationTimestamp
	private LocalDateTime submittedAt;
	
	public FeedbackEntity() {
		
	}

	public FeedbackEntity(Long feedbackId, TeacherEntity teacher, StudentEntity student, SubjectEntity subject,
			Integer semester, Double lat, Double lng, @Min(1) @Max(5) Integer question1_rating,
			@Min(1) @Max(5) Integer question2_rating, @Min(1) @Max(5) Integer question3_rating,
			@Min(1) @Max(5) Integer question4_rating, @Min(1) @Max(5) Integer question5_rating,
			LocalDateTime submittedAt) {
		super();
		this.feedbackId = feedbackId;
		this.teacher = teacher;
		this.student = student;
		this.subject = subject;
		this.semester = semester;
		this.lat = lat;
		this.lng = lng;
		this.question1_rating = question1_rating;
		this.question2_rating = question2_rating;
		this.question3_rating = question3_rating;
		this.question4_rating = question4_rating;
		this.question5_rating = question5_rating;
		this.submittedAt = submittedAt;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Integer getQuestion1_rating() {
		return question1_rating;
	}

	public void setQuestion1_rating(Integer question1_rating) {
		this.question1_rating = question1_rating;
	}

	public Integer getQuestion2_rating() {
		return question2_rating;
	}

	public void setQuestion2_rating(Integer question2_rating) {
		this.question2_rating = question2_rating;
	}

	public Integer getQuestion3_rating() {
		return question3_rating;
	}

	public void setQuestion3_rating(Integer question3_rating) {
		this.question3_rating = question3_rating;
	}

	public Integer getQuestion4_rating() {
		return question4_rating;
	}

	public void setQuestion4_rating(Integer question4_rating) {
		this.question4_rating = question4_rating;
	}

	public Integer getQuestion5_rating() {
		return question5_rating;
	}

	public void setQuestion5_rating(Integer question5_rating) {
		this.question5_rating = question5_rating;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

}
