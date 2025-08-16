package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class TeacherRequestDTO {

    private String name;
    private String email;
    private Long departmentId;

    public TeacherRequestDTO() {
    	
    }

    public TeacherRequestDTO(String name, String email, Long departmentId) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
