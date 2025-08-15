package com.mymood.feedbacksystem.Feedback.System.Entity;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subjectId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String code;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SubjectType type;
	
	@Column(unique = false, nullable = false)
	private Integer semester;
		
	public SubjectEntity() {
		
	}

	public SubjectEntity(Long subjectId, String name, String code, SubjectType type, Integer semester) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.code = code;
		this.type = type;
		this.semester = semester;
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

	public SubjectType getType() {
		return type;
	}

	public void setType(SubjectType type) {
		this.type = type;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

}
