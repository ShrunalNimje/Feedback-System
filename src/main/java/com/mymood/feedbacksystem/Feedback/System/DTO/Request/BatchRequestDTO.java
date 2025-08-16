package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class BatchRequestDTO {

    private String name;
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
