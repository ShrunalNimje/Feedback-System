package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Analytics.AnalyticsResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubmissionStatusDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.TeacherUpdateDTO;

public interface TeacherService {

	TeacherResponseDTO createTeacher(TeacherRequestDTO create);
    TeacherResponseDTO getTeacher(Long id);
    List<TeacherResponseDTO> getAllTeacher();
    TeacherResponseDTO updateTeacher(Long id, TeacherUpdateDTO update);
    void deleteTeacher(Long id);
    
    AnalyticsResponseDTO getTeacherAnalytics(Long teacherId, Integer semester, Long subjectId, Integer year);
    List<AnonymousFeedbackResponseDTO> getAnonymousFeedback(Long teacherId, Long subjectId, Integer semester);
    List<SubmissionStatusDTO> getFeedbackSubmissionStatus(Long subjectId, Integer semester, Long batchId);

}
