package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class Student1Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/feedback/form")
    public ResponseEntity<List<TeacherSubjectResponseDTO>> getAutoMappedFeedbackForm() {
        String enrollmentId = SecurityContextHolder.getContext().getAuthentication().getName();
        
        List<TeacherSubjectResponseDTO> response = studentService.getAutoMappedFeedbackForm(enrollmentId);
        return ResponseEntity.ok(response);
    }

}

