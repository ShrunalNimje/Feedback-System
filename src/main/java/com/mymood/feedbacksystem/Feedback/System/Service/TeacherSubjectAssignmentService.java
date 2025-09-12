package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherSubjectAssignmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectAssignmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.TeacherSubjectAssignmentUpdateDTO;

public interface TeacherSubjectAssignmentService {

	TeacherSubjectAssignmentResponseDTO createAssignment(TeacherSubjectAssignmentRequestDTO create);
    TeacherSubjectAssignmentResponseDTO getAssignment(Long id);
    List<TeacherSubjectAssignmentResponseDTO> getAllAssignment();
    TeacherSubjectAssignmentResponseDTO updateAssignment(Long id, TeacherSubjectAssignmentUpdateDTO update);
    void deleteAssignment(Long id);
}
