package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class StudentCSVDTO {
    
	private String enrollmentId;
    private String name;
    private Integer rollNo;
    private String department;
    private String branch;
    private String section;
    private String batch;
    private String email;
    private Integer semester;
    private String password;
    private Float attendancePercentage;
    
    public StudentCSVDTO() {
    	
    }

    public StudentCSVDTO(String enrollmentId, String department, String branch,
    		String section, String batch, String password) {
		this.enrollmentId = enrollmentId;
		this.department = department;
		this.branch = branch;
		this.section = section;
		this.batch = batch;
		this.password = password;
	}

	public StudentCSVDTO(String enrollmentId, String name, Integer rollNo, String department, String branch,
			String section, String batch, String email, Integer semester, String password, Float attendancePercentage) {
		super();
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.rollNo = rollNo;
		this.department = department;
		this.branch = branch;
		this.section = section;
		this.batch = batch;
		this.email = email;
		this.semester = semester;
		this.password = password;
		this.attendancePercentage = attendancePercentage;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(Float attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	
}

