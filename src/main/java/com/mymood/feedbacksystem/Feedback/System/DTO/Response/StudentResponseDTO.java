package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class StudentResponseDTO {

    private Long studentId;
    private String username;
    private String enrollmentId;
    private String name;
    private Integer rollNo;
    private String email;
    private String batchName;

    public StudentResponseDTO() {
    	
    }

    public StudentResponseDTO(Long studentId, String name, Integer rollNo, String email, 
    		String batchName, String username, String enrollmentId) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchName = batchName;
        this.username = username;
        this.enrollmentId = enrollmentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
}

