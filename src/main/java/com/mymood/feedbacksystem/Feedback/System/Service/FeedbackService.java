package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.FeedbackResponseDTO;

public interface FeedbackService {

	FeedbackResponseDTO submitFeedback(FeedbackRequestDTO submit);

    List<FeedbackResponseDTO> getFeedbackByStudent(Long studentId);

    List<FeedbackResponseDTO> getFeedbackByTeacher(Long teacherId);

    List<FeedbackResponseDTO> getFeedbackBySubject(Long subjectId);
}
