package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.Size;

public class BatchUpdateDTO {

	@Size(min = 2, max = 2, message = "Batch name must be exactly 2 characters")
	private String name;

	private Long sectionId;

    public BatchUpdateDTO() {
    	
    }

    public BatchUpdateDTO(String name, Long sectionId) {
        this.name = name;
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
