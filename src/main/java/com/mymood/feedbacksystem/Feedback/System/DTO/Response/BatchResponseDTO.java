package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class BatchResponseDTO {

    private Long batchId;
    private String name;
    private String sectionName;

    public BatchResponseDTO() {
    	
    }

    public BatchResponseDTO(Long batchId, String name, String sectionName) {
        this.batchId = batchId;
        this.name = name;
        this.sectionName = sectionName;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
