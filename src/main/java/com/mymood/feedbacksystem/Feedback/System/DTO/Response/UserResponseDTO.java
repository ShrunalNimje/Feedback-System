package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import com.mymood.feedbacksystem.Feedback.System.Enum.Role;

public class UserResponseDTO {

    private Long userId;
    private String username;
    private Role role;

    public UserResponseDTO() {
    	
	}

	public UserResponseDTO(Long userId, String username, Role role) {
		this.userId = userId;
		this.username = username;
		this.role = role;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
