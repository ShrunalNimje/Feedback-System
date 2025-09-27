package com.mymood.feedbacksystem.Feedback.System.DTO.Update;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class StudentUpdateDTO {

	private String password; 

    @Size(max = 100, message = "Name can be up to 100 characters")
    private String name;     

    @Min(value = 1, message = "Roll number must be positive")
    private Integer rollNo;  

    @Email(message = "Email should be valid")
    private String email;    

    private Long batchId;    
    
    @Min(value = 1, message = "Semester must be positive")
    private Integer semester;   

    @DecimalMin(value = "0.0", message = "Attendance cannot be negative")
    @DecimalMax(value = "100.0", message = "Attendance cannot exceed 100")
    private Float attendance;

    public StudentUpdateDTO() {
    	
    }

    public StudentUpdateDTO(String name, Integer rollNo, String email, Long batchId, 
    		String password, Integer semester, Float attendance) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchId = batchId;
        this.password = password;
        this.semester = semester;
        this.attendance = attendance;
    }

    public Float getAttendance() {
		return attendance;
	}

	public void setAttendance(Float attendance) {
		this.attendance = attendance;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
