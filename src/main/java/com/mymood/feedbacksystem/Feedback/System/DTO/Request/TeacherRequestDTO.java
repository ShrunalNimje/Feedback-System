package com.mymood.feedbacksystem.Feedback.System.DTO.Request;

public class TeacherRequestDTO {

	private String username;
    private String password;
    private String name;
    private String email;
    private Long departmentId;

    public TeacherRequestDTO() {
    	
    }

    public TeacherRequestDTO(String name, String email, Long departmentId, String username, String password) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.username = username;
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
