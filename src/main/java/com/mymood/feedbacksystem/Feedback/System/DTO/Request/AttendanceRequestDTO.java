package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class AttendanceRequestDTO {

    private Long studentId;
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
