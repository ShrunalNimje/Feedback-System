package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class TeacherUpdateDTO {

	private String password; 

    @Size(max = 100, message = "Name can be up to 100 characters")
    private String name;   

    @Email(message = "Please provide a valid email")
    private String email;    

    private Long departmentId;

    public TeacherUpdateDTO() {
    	
    }

    public TeacherUpdateDTO(String name, String email, Long departmentId, String password) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
