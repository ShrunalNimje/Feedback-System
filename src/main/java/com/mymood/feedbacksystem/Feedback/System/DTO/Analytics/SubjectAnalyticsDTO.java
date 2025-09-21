package com.mymood.feedbacksystem.Feedback.System.DTO.Analytics;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

public class SubjectAnalyticsDTO {
    
	private Long subjectId;
    private String subjectName;
    private SubjectType type;
    private List<SectionAverageDTO> averageBySection;
    private List<BatchAverageDTO> averageByBatch;
    private List<QuestionAverageDTO> questionWiseAverage;

    public SubjectAnalyticsDTO() {
    	
    }
    
    public SubjectAnalyticsDTO(Long subjectId, String subjectName, SubjectType type,
                               List<SectionAverageDTO> averageBySection,
                               List<BatchAverageDTO> averageByBatch,
                               List<QuestionAverageDTO> questionWiseAverage) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.type = type;
        this.averageBySection = averageBySection;
        this.averageByBatch = averageByBatch;
        this.questionWiseAverage = questionWiseAverage;
    }

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public SubjectType getType() {
		return type;
	}

	public void setType(SubjectType type) {
		this.type = type;
	}

	public List<SectionAverageDTO> getAverageBySection() {
		return averageBySection;
	}

	public void setAverageBySection(List<SectionAverageDTO> averageBySection) {
		this.averageBySection = averageBySection;
	}

	public List<BatchAverageDTO> getAverageByBatch() {
		return averageByBatch;
	}

	public void setAverageByBatch(List<BatchAverageDTO> averageByBatch) {
		this.averageByBatch = averageByBatch;
	}

	public List<QuestionAverageDTO> getQuestionWiseAverage() {
		return questionWiseAverage;
	}

	public void setQuestionWiseAverage(List<QuestionAverageDTO> questionWiseAverage) {
		this.questionWiseAverage = questionWiseAverage;
	}

}

