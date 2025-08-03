package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teachers")
public class TeacherEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherId;
	
	@Column(unique = false, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	@Email(message = "Please give a valid mail Id!")
	private String email;
	
	@Size(min = 8, message = "Password should be of atleast 8 characters!")
	@Column(unique = false, nullable = false)
	private String password;
	
	private DepartmentEntity department;
	
	public TeacherEntity() {
		
	}

	public TeacherEntity(Long teacherId, String name, @Email(message = "Please give a valid mail Id!") String email,
			@Size(min = 8, message = "Password should be of atleast 8 characters!") String password,
			DepartmentEntity department) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.department = department;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
