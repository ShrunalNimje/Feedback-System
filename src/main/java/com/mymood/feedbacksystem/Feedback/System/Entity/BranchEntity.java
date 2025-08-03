package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "branches")
public class BranchEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long branchId;
	
	private DepartmentEntity department;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	public BranchEntity() {
		
	}

	public BranchEntity(Long branchId, DepartmentEntity department, String name) {
		super();
		this.branchId = branchId;
		this.department = department;
		this.name = name;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
