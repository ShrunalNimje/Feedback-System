package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;

public interface FeedbackService {

	List<AnonymousFeedbackResponseDTO> submitFeedback(List<FeedbackRequestDTO> submits);

    List<AnonymousFeedbackResponseDTO> getFeedbackByStudent(Long studentId, Long loggedInUserId, String roleStr);

    List<AnonymousFeedbackResponseDTO> getFeedbackByTeacher(Long teacherId, Long loggedInUserId, String roleStr);

    List<AnonymousFeedbackResponseDTO> getFeedbackBySubject(Long subjectId, Long loggedInUserId, String roleStr);
}
