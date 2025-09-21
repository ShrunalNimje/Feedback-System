package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubmissionStatusDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/feedback/submission-status")
    public ResponseEntity<List<SubmissionStatusDTO>> getSubmissionStatus(
            @RequestParam Long subjectId,
            @RequestParam Integer semester,
            @RequestParam Long batchId) {

        List<SubmissionStatusDTO> statusList = teacherService.getFeedbackSubmissionStatus(subjectId, semester, batchId);
        return ResponseEntity.ok(statusList);
    }
}

