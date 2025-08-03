package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subjectId;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String code;
	
	@Column(unique = true, nullable = false)
	private String type;
	
	@Column(unique = false, nullable = false)
	private String semester;
	
	private DepartmentEntity department;
	
	public SubjectEntity() {
		
	}

	public SubjectEntity(Long subjectId, String name, String code, String type, String semester,
			DepartmentEntity department) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.code = code;
		this.type = type;
		this.semester = semester;
		this.department = department;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
