package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SectionRequestDTO {

	@NotBlank(message = "Section name is required")
	@Size(min = 1, max = 1, message = "Section name must be exactly 1 character")
	private String name;

	@NotNull(message = "Branch ID must be provided")
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
