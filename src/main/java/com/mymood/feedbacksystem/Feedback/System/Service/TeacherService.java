package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;

public interface TeacherService {

	TeacherResponseDTO createTeacher(TeacherRequestDTO create);
    TeacherResponseDTO getTeacher(Long id);
    List<TeacherResponseDTO> getAllTeacher();
    TeacherResponseDTO updateTeacher(Long id, TeacherRequestDTO update);
    void deleteTeacher(Long id);
}
