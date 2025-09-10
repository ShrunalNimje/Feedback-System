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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.AttendanceRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AttendanceResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.AttendanceService;

@RestController
@RequestMapping("/api/admin/attendances")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@GetMapping("/{studentId}")
	public AttendanceResponseDTO getAttendanceByStudent(@PathVariable Long studentId) {
		return attendanceService.getAttendanceByStudent(studentId);
	}
	
	@PostMapping()
	public ResponseEntity<String> addAttendance(@RequestBody AttendanceRequestDTO add) {
		attendanceService.addAttendance(add);
		return ResponseEntity.ok("Attendance added successfully!");
	}
	
	@GetMapping()
	public List<AttendanceResponseDTO> getAllAttendance() {
		return attendanceService.getAllAttendance();
	}
	
}
