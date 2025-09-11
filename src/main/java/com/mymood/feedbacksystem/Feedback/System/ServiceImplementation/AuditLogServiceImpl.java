package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AuditLogResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.AuditLogEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.AuditLogRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.AuditLogService;

@Service
public class AuditLogServiceImpl implements AuditLogService{

	@Autowired
	AuditLogRepository auditLogRepository;
	
	@Autowired
    UserRepository userRepository;
	
	@Override
	public void logAction(Long userId, String action, String ipAddress) {
		
		UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        AuditLogEntity log = new AuditLogEntity();
        log.setUser(user);
        log.setAction(action);
        log.setIpAddress(ipAddress);
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);
	}

	@Override
	public List<AuditLogResponseDTO> getAllLogs() {
		
		return auditLogRepository.findAll()
                .stream()
                .map(log -> new AuditLogResponseDTO(
                        log.getLogId(),
                        log.getUser().getUserId(),
                        log.getAction(),
                        log.getTimestamp(),
                        log.getIpAddress()))
                .collect(Collectors.toList());
	}

	@Override
	public List<AuditLogResponseDTO> getLogsByUser(Long userId) {
		
		return auditLogRepository.findByUser_UserId(userId)
                .stream()
                .map(log -> new AuditLogResponseDTO(
                        log.getLogId(),
                        log.getUser().getUserId(),
                        log.getAction(),
                        log.getTimestamp(),
                        log.getIpAddress()))
                .collect(Collectors.toList());
	}

}
