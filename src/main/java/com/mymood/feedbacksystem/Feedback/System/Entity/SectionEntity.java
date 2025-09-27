package com.mymood.feedbacksystem.Feedback.System.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sections")
public class SectionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sectionId;
		
	@Column(nullable = false, length = 1)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private BranchEntity branch;

	@OneToMany(mappedBy = "section")
	private List<BatchEntity> batches;

	@OneToMany(mappedBy = "section")
	private List<TeacherSubjectAssignmentEntity> assignments;

	public SectionEntity() {
		
	}

	public SectionEntity(String name) {
		this.name = name;
	}
	
	public SectionEntity(Long sectionId, String name, BranchEntity branch, List<BatchEntity> batches,
			List<TeacherSubjectAssignmentEntity> assignments) {
		super();
		this.sectionId = sectionId;
		this.name = name;
		this.branch = branch;
		this.batches = batches;
		this.assignments = assignments;
	}

	public List<BatchEntity> getBatches() {
		return batches;
	}

	public void setBatches(List<BatchEntity> batches) {
		this.batches = batches;
	}

	public List<TeacherSubjectAssignmentEntity> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<TeacherSubjectAssignmentEntity> assignments) {
		this.assignments = assignments;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}
	
}
