package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;

public interface StudentService {

	StudentResponseDTO createStudent(StudentRequestDTO create);
    StudentResponseDTO getStudent(Long id);
    List<StudentResponseDTO> getAllStudent();
    StudentResponseDTO updateStudent(Long id, StudentRequestDTO update);
    void deleteStudent(Long id);
}
