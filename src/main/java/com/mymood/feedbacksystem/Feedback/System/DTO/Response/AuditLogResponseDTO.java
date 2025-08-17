package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import java.time.LocalDateTime;

public class AuditLogResponseDTO {

    private Long logId;
    private Long userId;
    private String action;
    private LocalDateTime timestamp;
    private String ipAddress;

    public AuditLogResponseDTO() {
    	
    }

    public AuditLogResponseDTO(Long logId, Long userId, String action, LocalDateTime timestamp, String ipAddress) {
        this.logId = logId;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
        this.ipAddress = ipAddress;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
