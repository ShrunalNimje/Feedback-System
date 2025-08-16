package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class StudentResponseDTO {

    private Long studentId;
    private String name;
    private String rollNo;
    private String email;
    private String batchName;

    public StudentResponseDTO() {
    	
    }

    public StudentResponseDTO(Long studentId, String name, String rollNo, String email, String batchName) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchName = batchName;
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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
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
}

