package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sections")
public class SectionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sectionId;
	
	private BranchEntity branch;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	public SectionEntity() {
		
	}

	public SectionEntity(Long sectionId, BranchEntity branch, String name) {
		super();
		this.sectionId = sectionId;
		this.branch = branch;
		this.name = name;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
