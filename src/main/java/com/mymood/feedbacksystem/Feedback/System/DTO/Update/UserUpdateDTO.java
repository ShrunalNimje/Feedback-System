package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import com.mymood.feedbacksystem.Feedback.System.Enum.Role;

public class UserUpdateDTO {

    private String password;
    private Role role;

    public UserUpdateDTO() {
    	
	}

	public UserUpdateDTO(String password, Role role) {
		this.password = password;
		this.role = role;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
