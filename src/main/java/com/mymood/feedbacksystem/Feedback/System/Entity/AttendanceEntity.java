package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendances")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long attendanceId;
	
	@Column(nullable = false)
	private StudentEntity student;
	
	@Column(nullable = false)
	private SubjectEntity subject;
	
	@Column(nullable = false)
	private Integer presentDays;
	
	@Column(nullable = false)
	private Integer totalDays;
	
	@Column(nullable = false)
	private Double attendancePercentage;
	
	public AttendanceEntity() {
		
	}

	public AttendanceEntity(Long attendanceId, StudentEntity student, SubjectEntity subject, Integer presentDays,
			Integer totalDays, Double attendancePercentage) {
		super();
		this.attendanceId = attendanceId;
		this.student = student;
		this.subject = subject;
		this.presentDays = presentDays;
		this.totalDays = totalDays;
		this.attendancePercentage = attendancePercentage;
	}

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
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

	public Integer getPresentDays() {
		return presentDays;
	}

	public void setPresentDays(Integer presentDays) {
		this.presentDays = presentDays;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	public Double getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(Double attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	
}
