package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class SectionResponseDTO {

    private Long sectionId;
    private String name;
    private String branchName;

    public SectionResponseDTO() {
    	
    }

    public SectionResponseDTO(Long sectionId, String name, String branchName) {
        this.sectionId = sectionId;
        this.name = name;
        this.branchName = branchName;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
