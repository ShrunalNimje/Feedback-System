package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {

	@NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Roll number is required")
    private Integer rollNo;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Batch ID is required")
    private Long batchId;

    @NotBlank(message = "Enrollment ID is required")
    private String enrollmentId;

    @NotNull(message = "Semester is required")
    private Integer semester;

    @NotNull(message = "Attendance percentage is required")
    @DecimalMin(value = "0.0", message = "Attendance cannot be less than 0")
    @DecimalMax(value = "100.0", message = "Attendance cannot be more than 100")
    private Float attendance;

    public StudentRequestDTO() {
    	
    }

    public StudentRequestDTO(String name, Integer rollNo, String email, Long batchId, 
    		String enrollmentId, String password, Integer semester, Float attendance) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchId = batchId;
        this.enrollmentId = enrollmentId;
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

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
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
