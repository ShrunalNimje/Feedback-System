package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.Size;

public class SectionUpdateDTO {

	@Size(min = 1, max = 1, message = "Section name must be exactly 1 character")
	private String name;

	private Long branchId;

    public SectionUpdateDTO() {
    }

    public SectionUpdateDTO(String name, Long branchId) {
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
