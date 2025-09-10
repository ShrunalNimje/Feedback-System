package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.AuditLogRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AuditLogResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.AuditLogService;

@RestController
@RequestMapping("/api/admin/audit-logs")
public class AuditLogController {

	@Autowired
	AuditLogService auditLogService;
	
	@PostMapping()
	public ResponseEntity<String> logAction(@RequestBody AuditLogRequestDTO request) {
		auditLogService.logAction(request.getUserId(), request.getAction(), request.getIpAddress());
		return ResponseEntity.ok("Audit-log saved successfully!");
	}
	
	@GetMapping()
	public List<AuditLogResponseDTO> getAllLogs() {
		return auditLogService.getAllLogs();
	}
	
	@GetMapping("/{userId}")
	public List<AuditLogResponseDTO> getLogsByUser(@PathVariable Long userId) {
		return auditLogService.getLogsByUser(userId);
	}
}
