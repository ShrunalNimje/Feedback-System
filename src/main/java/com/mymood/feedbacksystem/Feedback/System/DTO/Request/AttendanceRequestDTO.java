package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class AttendanceRequestDTO {

	@NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Attendance percentage is required")
    @DecimalMin(value = "0.0", message = "Attendance cannot be less than 0")
    @DecimalMax(value = "100.0", message = "Attendance cannot be more than 100")
    private Double attendancePercentage;

    public AttendanceRequestDTO() {
    }

    public AttendanceRequestDTO(Long studentId, Double attendancePercentage) {
        this.studentId = studentId;
        this.attendancePercentage = attendancePercentage;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(Double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}
