package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	public DepartmentEntity() {
		
	}
	
	public DepartmentEntity(Long deptId, String name) {
		super();
		this.deptId = deptId;
		this.name = name;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
