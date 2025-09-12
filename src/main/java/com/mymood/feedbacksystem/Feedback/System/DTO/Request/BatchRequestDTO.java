package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BatchRequestDTO {

	@NotBlank(message = "Batch name is required")
	@Size(min = 2, max = 2, message = "Batch name must be exactly 2 characters")
	private String name;

	@NotNull(message = "Section ID must be provided")
	private Long sectionId;

    public BatchRequestDTO() {
    	
    }

    public BatchRequestDTO(String name, Long sectionId) {
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
