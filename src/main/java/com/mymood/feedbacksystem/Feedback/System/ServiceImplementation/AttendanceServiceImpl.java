package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.AttendanceRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AttendanceResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.AttendanceEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.AttendanceRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	AttendanceRepository attendanceRepository;
    
	@Autowired
	StudentRepository studentRepository;

	@Override
	public AttendanceResponseDTO getAttendanceByStudent(Long studentId) {
		
		AttendanceEntity attendance = attendanceRepository.findByStudent_StudentId(studentId).orElseThrow(
				() -> new RuntimeException("Attendance not found for student!"));

        return new AttendanceResponseDTO(
                attendance.getAttendanceId(),
                attendance.getStudent().getName(),
                attendance.getAttendancePercentage()
        );
	}

	@Override
	public AttendanceResponseDTO addAttendance(AttendanceRequestDTO add) {
		
		StudentEntity student = studentRepository.findById(add.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        AttendanceEntity attendance = new AttendanceEntity();
        attendance.setStudent(student);
        attendance.setAttendancePercentage(add.getAttendancePercentage());

        AttendanceEntity saved = attendanceRepository.save(attendance);

        return new AttendanceResponseDTO(
                saved.getAttendanceId(),
                saved.getStudent().getName(),
                saved.getAttendancePercentage());
	}

	@Override
	public List<AttendanceResponseDTO> getAllAttendance() {
		
		return attendanceRepository.findAll()
                .stream()
                .map(attendance -> new AttendanceResponseDTO(
                		attendance.getAttendanceId(),
                		attendance.getStudent().getName(),
                		attendance.getAttendancePercentage()))
                .collect(Collectors.toList());
	}

}
