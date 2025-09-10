package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "teachers")
public class TeacherEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	
	@Column(unique = false, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	@Email(message = "Please give a valid mail Id!")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private DepartmentEntity department;
	
	@OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
	
	public TeacherEntity() {
		
	}

	public TeacherEntity(Long teacherId, String name, String email, DepartmentEntity department, UserEntity user) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.user = user;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
