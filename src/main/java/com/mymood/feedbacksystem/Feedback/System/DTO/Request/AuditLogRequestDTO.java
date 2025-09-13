package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuditLogRequestDTO {

	@NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Action is required")
    private String action;

    @NotBlank(message = "IP Address is required")
    private String ipAddress;

    public AuditLogRequestDTO() {
    	
    }

    public AuditLogRequestDTO(Long userId, String action, String ipAddress) {
        this.userId = userId;
        this.action = action;
        this.ipAddress = ipAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
