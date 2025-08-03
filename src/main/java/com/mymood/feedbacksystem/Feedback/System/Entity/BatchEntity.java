package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "batches")
public class BatchEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long batchId;
	
	private SectionEntity section;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	public BatchEntity() {
		
	}

	public BatchEntity(Long batchId, SectionEntity section, String name) {
		super();
		this.batchId = batchId;
		this.section = section;
		this.name = name;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public SectionEntity getSection() {
		return section;
	}

	public void setSection(SectionEntity section) {
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
