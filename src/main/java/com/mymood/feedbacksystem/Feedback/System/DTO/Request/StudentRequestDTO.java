package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class StudentRequestDTO {

    private String name;
    private String rollNo;
    private String email;
    private Long batchId;

    public StudentRequestDTO() {
    	
    }

    public StudentRequestDTO(String name, String rollNo, String email, Long batchId) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.batchId = batchId;
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

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }
}
