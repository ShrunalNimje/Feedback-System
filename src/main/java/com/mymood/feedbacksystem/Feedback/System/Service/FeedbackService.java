package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;

public interface FeedbackService {

	AnonymousFeedbackResponseDTO submitFeedback(FeedbackRequestDTO submit);

    List<AnonymousFeedbackResponseDTO> getFeedbackByStudent(Long studentId);

    List<AnonymousFeedbackResponseDTO> getFeedbackByTeacher(Long teacherId);

    List<AnonymousFeedbackResponseDTO> getFeedbackBySubject(Long subjectId);
}
