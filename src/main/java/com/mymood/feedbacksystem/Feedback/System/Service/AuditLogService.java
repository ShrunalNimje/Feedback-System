package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AuditLogResponseDTO;

public interface AuditLogService {

	void logAction(Long userId, String action, String ipAddress);
    List<AuditLogResponseDTO> getAllLogs();
    List<AuditLogResponseDTO> getLogsByUser(Long userId);
}
