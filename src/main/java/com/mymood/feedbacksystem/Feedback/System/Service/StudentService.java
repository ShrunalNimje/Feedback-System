package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentCSVDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.StudentUpdateDTO;

public interface StudentService {

	StudentResponseDTO createStudent(StudentRequestDTO create);
    StudentResponseDTO getStudent(Long id);
    List<StudentResponseDTO> getAllStudent();
    StudentResponseDTO updateStudent(Long id, StudentUpdateDTO update);
    void deleteStudent(Long id);
    
    List<TeacherSubjectResponseDTO> getAutoMappedFeedbackForm(String enrollmentId);
//    List<StudentCSVDTO> parseCSV(MultipartFile file) throws Exception;
//    void saveStudentsFromCSV(MultipartFile file) throws Exception;

}
