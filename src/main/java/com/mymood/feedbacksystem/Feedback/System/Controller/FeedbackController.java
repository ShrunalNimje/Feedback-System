package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.FeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> submitFeedback(@Valid @RequestBody FeedbackRequestDTO request) {
        FeedbackResponseDTO saved = feedbackService.submitFeedback(request);
        return ResponseEntity.ok("Feedback submitted successfully with id = " + saved.getFeedbackId());
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<FeedbackResponseDTO> getFeedbackByStudent(@PathVariable Long studentId) {
        return feedbackService.getFeedbackByStudent(studentId);
    }

    @GetMapping("/teacher/{teacherId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<FeedbackResponseDTO> getFeedbackByTeacher(@PathVariable Long teacherId) {
        return feedbackService.getFeedbackByTeacher(teacherId);
    }

    @GetMapping("/subject/{subjectId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<FeedbackResponseDTO> getFeedbackBySubject(@PathVariable Long subjectId) {
        return feedbackService.getFeedbackBySubject(subjectId);
    }
}

