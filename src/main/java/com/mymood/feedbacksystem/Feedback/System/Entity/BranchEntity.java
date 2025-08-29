package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "branches")
public class BranchEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
		
	@Column(unique = true, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private DepartmentEntity department;
	
	public BranchEntity() {
		
	}

	public BranchEntity(Long branchId, String name, DepartmentEntity department) {
		super();
		this.branchId = branchId;
		this.name = name;
		this.department = department;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
}
