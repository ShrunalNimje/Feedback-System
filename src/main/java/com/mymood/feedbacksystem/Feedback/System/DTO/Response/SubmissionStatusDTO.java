package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

public class SubmissionStatusDTO {
   
	private String enrollmentId;
    private boolean submitted;

    public SubmissionStatusDTO() {
    	
    }
    
    public SubmissionStatusDTO(String enrollmentId, boolean submitted) {
        this.enrollmentId = enrollmentId;
        this.submitted = submitted;
    }

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

}

