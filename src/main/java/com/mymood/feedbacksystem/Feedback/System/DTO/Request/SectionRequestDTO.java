package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class SectionRequestDTO {

    private String name;
    private Long branchId;

    public SectionRequestDTO() {
    }

    public SectionRequestDTO(String name, Long branchId) {
        this.name = name;
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
