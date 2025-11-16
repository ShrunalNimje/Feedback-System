package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.FeedbackRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.AnonymousFeedbackResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Security.CustomUserDetails;
import com.mymood.feedbacksystem.Feedback.System.Service.FeedbackService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

//    @PostMapping("/submit")
//    @PreAuthorize("hasRole('STUDENT')")
//    public ResponseEntity<String> submitFeedback(@Valid @RequestBody FeedbackRequestDTO request) {
//        AnonymousFeedbackResponseDTO saved = feedbackService.submitFeedback(request);
//        return ResponseEntity.ok("Feedback submitted successfully with id = " + saved.getFeedbackId());
//    }

    @PostMapping("/submit")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> submitFeedback(@Valid @RequestBody @NotEmpty List<@Valid FeedbackRequestDTO> requests) {

        requests.forEach(dto -> {
            System.out.println("Received DTO: enrollmentId=" + dto.getEnrollmentId()
                + ", teacherId=" + dto.getTeacherId()
                + ", subjectId=" + dto.getSubjectId());
        });

        feedbackService.submitFeedback(requests);
        return ResponseEntity.ok("Feedback submitted successfully for all subjects.");
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<AnonymousFeedbackResponseDTO> getFeedbackByStudent(@PathVariable Long studentId, 
    		@AuthenticationPrincipal CustomUserDetails userDetails) {
    	
    	Long loggedInUserId = userDetails.getUserId();
        return feedbackService.getFeedbackByStudent(studentId, loggedInUserId, userDetails.getRole());
    }

    @GetMapping("/teacher/{teacherId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<AnonymousFeedbackResponseDTO> getFeedbackByTeacher(@PathVariable Long teacherId, 
    		@AuthenticationPrincipal CustomUserDetails userDetails) {
        
    	Long loggedInUserId = userDetails.getUserId();
    	return feedbackService.getFeedbackByTeacher(teacherId, loggedInUserId, userDetails.getRole());
    }

    @GetMapping("/subject/{subjectId}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public List<AnonymousFeedbackResponseDTO> getFeedbackBySubject(@PathVariable Long subjectId, 
    		@AuthenticationPrincipal CustomUserDetails userDetails) {
    	
    	Long teacherUserId = userDetails.getUserId();
        return feedbackService.getFeedbackBySubject(subjectId, teacherUserId, userDetails.getRole());
    }
}

