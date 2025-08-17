package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class AttendanceResponseDTO {

    private Long attendanceId;
    private String studentName;
    private Double attendancePercentage;

    public AttendanceResponseDTO() {
    }

    public AttendanceResponseDTO(Long attendanceId, String studentName, Double attendancePercentage) {
        this.attendanceId = attendanceId;
        this.studentName = studentName;
        this.attendancePercentage = attendancePercentage;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(Double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}
