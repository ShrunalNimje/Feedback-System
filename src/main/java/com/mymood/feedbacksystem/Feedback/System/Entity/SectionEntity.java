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
	
	public SectionEntity() {
		
	}

	public SectionEntity(Long sectionId, String name, BranchEntity branch) {
		super();
		this.sectionId = sectionId;
		this.name = name;
		this.branch = branch;
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
