package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class RoleResponseDTO {

    private Long roleId;
    private String name;

    public RoleResponseDTO() {
    	
	}

	public RoleResponseDTO(Long roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
