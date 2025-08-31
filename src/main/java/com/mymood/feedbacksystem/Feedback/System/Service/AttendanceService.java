package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.AttendanceRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AttendanceResponseDTO;

public interface AttendanceService {

	AttendanceResponseDTO addAttendance(AttendanceRequestDTO add);
    List<AttendanceResponseDTO> getAllAttendance();
    AttendanceResponseDTO getAttendanceByStudent(Long studentId);
}
