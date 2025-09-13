package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherSubjectAssignmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectAssignmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.TeacherSubjectAssignmentUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherSubjectAssignmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/assignments")
public class TeacherSubjectAssignmentController {

	@Autowired
    private TeacherSubjectAssignmentService assignmentService;

    @PostMapping()
    public ResponseEntity<String> createAssignment(@Valid @RequestBody TeacherSubjectAssignmentRequestDTO request) {
        TeacherSubjectAssignmentResponseDTO saved = assignmentService.createAssignment(request);
        return ResponseEntity.ok("Assignment created successfully with id = " + saved.getTeacherSubjectAssignmentId());
    }

    @GetMapping("/{assignmentId}")
    public TeacherSubjectAssignmentResponseDTO getAssignment(@PathVariable Long assignmentId) {
        return assignmentService.getAssignment(assignmentId);
    }

    @GetMapping()
    public List<TeacherSubjectAssignmentResponseDTO> getAllAssignments() {
        return assignmentService.getAllAssignment();
    }

    @PutMapping("/{assignmentId}")
    public ResponseEntity<String> updateAssignment(@PathVariable Long assignmentId, @Valid @RequestBody TeacherSubjectAssignmentUpdateDTO update) {
        assignmentService.updateAssignment(assignmentId, update);
        return ResponseEntity.ok("Assignment updated successfully with id = " + assignmentId);
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return ResponseEntity.ok("Assignment deleted successfully with id = " + assignmentId);
    }
}
