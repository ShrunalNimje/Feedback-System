package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class StudentRequestDTO {

	private String username;
    private String password;
    private String name;
    private Integer rollNo;
    private String email;
    private Long batchId;
    private String enrollmentId;

    public StudentRequestDTO() {
    	
    }

    public StudentRequestDTO(String name, Integer rollNo, String email, Long batchId, 
    		String enrollmentId, String username, String password) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchId = batchId;
        this.enrollmentId = enrollmentId;
        this.username = username;
        this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
