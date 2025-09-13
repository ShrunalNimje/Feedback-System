package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class TeacherResponseDTO {

    private Long teacherId;
    private String name;
    private String email;
    private String departmentName;

    public TeacherResponseDTO() {
    	
    }

    public TeacherResponseDTO(Long teacherId, String name, String email, String departmentName) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
