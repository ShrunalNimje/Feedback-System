package com.mymood.feedbacksystem.Feedback.System.DTO.Analytics;

public class SectionAverageDTO {
    
	private String section;
    private Double avgRating;

    public SectionAverageDTO() {
		super();
	}

	public SectionAverageDTO(String section, Double avgRating) {
        this.section = section;
        this.avgRating = avgRating;
    }

    public String getSection() { 
    	return section; 
    }

    public void setSection(String section) { 
    	this.section = section; 
    }

    public Double getAvgRating() {
    	return avgRating; 
    }
    
    public void setAvgRating(Double avgRating) {
    	this.avgRating = avgRating; 
    }
}

