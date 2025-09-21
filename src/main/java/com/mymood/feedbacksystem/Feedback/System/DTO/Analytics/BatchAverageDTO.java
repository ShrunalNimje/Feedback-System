package com.mymood.feedbacksystem.Feedback.System.DTO.Analytics;

public class BatchAverageDTO {
    
	private String batch;
    private Double avgRating;

    public BatchAverageDTO() {
    	
    }
    
    public BatchAverageDTO(String batch, Double avgRating) {
        this.batch = batch;
        this.avgRating = avgRating;
    }

    public String getBatch() {
    	return batch; 
    }
    
    public void setBatch(String batch) {
    	this.batch = batch; 
    }

    public Double getAvgRating() { 
    	return avgRating; 
    }
    
    public void setAvgRating(Double avgRating) { 
    	this.avgRating = avgRating; 
    }
}

