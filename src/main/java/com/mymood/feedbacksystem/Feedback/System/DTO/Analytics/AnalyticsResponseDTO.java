package com.mymood.feedbacksystem.Feedback.System.DTO.Analytics;

import java.util.List;

public class AnalyticsResponseDTO {
    
	private Long teacherId;
    private List<SubjectAnalyticsDTO> analytics;

    public AnalyticsResponseDTO() {
    	
    }
    
    public AnalyticsResponseDTO(Long teacherId, List<SubjectAnalyticsDTO> analytics) {
        this.teacherId = teacherId;
        this.analytics = analytics;
    }

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public List<SubjectAnalyticsDTO> getAnalytics() {
		return analytics;
	}

	public void setAnalytics(List<SubjectAnalyticsDTO> analytics) {
		this.analytics = analytics;
	}

}

