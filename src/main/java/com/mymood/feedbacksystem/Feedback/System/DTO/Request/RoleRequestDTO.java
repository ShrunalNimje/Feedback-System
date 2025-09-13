package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public class RoleRequestDTO {

	@NotBlank(message = "Role name is required")
    private String name;
	
    public RoleRequestDTO() {
    	
    }
    
    public RoleRequestDTO(String name) {
    	this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
