package com.mymood.feedbacksystem.Feedback.System.DTO.Analytics;

public class QuestionAverageDTO {
   
	private String question;
    private Double avgRating;

    public QuestionAverageDTO() {
    	
    }
    
    public QuestionAverageDTO(String question, Double avgRating) {
        this.question = question;
        this.avgRating = avgRating;
    }

    public String getQuestion() { 
    	return question; 
    }
    
    public void setQuestion(String question) {
    	this.question = question; 
	}

    public Double getAvgRating() {
    	return avgRating;
	}
    
    public void setAvgRating(Double avgRating) {
    	this.avgRating = avgRating; 
    }
}

