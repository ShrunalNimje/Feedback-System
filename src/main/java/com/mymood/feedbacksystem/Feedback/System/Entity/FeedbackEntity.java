package com.mymood.feedbacksystem.Feedback.System.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "feedbacks")
public class FeedbackEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedbackId;
	
	@Column(nullable = false)
	private TeacherEntity teacher;
	
	@Column(nullable = false)
	private StudentEntity student;
	
	@Column(nullable = false)
	private SubjectEntity subject;
	
	@Column(nullable = false)
	private Integer semester;
	
	@Column(nullable = false)
	private Double lat;
	
	@Column(nullable = false)
	private Double lng;
	
	@Column(nullable = false)
	@Size(max = 1, message = "Rating should be of only 1 digit between 1 to 5!")
	private Integer question1_rating;
	
	@Column(nullable = false)
	@Size(max = 1, message = "Rating should be of only 1 digit between 1 to 5!")
	private Integer question2_rating;
	
	@Column(nullable = false)
	@Size(max = 1, message = "Rating should be of only 1 digit between 1 to 5!")
	private Integer question3_rating;
	
	@Column(nullable = false)
	@Size(max = 1, message = "Rating should be of only 1 digit between 1 to 5!")
	private Integer question4_rating;
	
	@Column(nullable = false)
	@Size(max = 1, message = "Rating should be of only 1 digit between 1 to 5!")
	private Integer question5_rating;
	
	@CurrentTimestamp
	private LocalDateTime submittedAt;
	
	public FeedbackEntity() {
		
	}

}
