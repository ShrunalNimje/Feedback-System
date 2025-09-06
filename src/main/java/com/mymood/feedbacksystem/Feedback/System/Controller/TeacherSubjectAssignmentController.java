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
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherSubjectAssignmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectAssignmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherSubjectAssignmentService;

@RestController
public class TeacherSubjectAssignmentController {

	@Autowired
    private TeacherSubjectAssignmentService assignmentService;

    @PostMapping("/assignment")
    public ResponseEntity<String> createAssignment(@RequestBody TeacherSubjectAssignmentRequestDTO request) {
        TeacherSubjectAssignmentResponseDTO saved = assignmentService.createAssignment(request);
        return ResponseEntity.ok("Assignment created successfully with id = " + saved.getTeacherSubjectAssignmentId());
    }

    @GetMapping("/assignment/{assignmentId}")
    public TeacherSubjectAssignmentResponseDTO getAssignment(@PathVariable Long assignmentId) {
        return assignmentService.getAssignment(assignmentId);
    }

    @GetMapping("/assignment")
    public List<TeacherSubjectAssignmentResponseDTO> getAllAssignments() {
        return assignmentService.getAllAssignment();
    }

    @PutMapping("/assignment/{assignmentId}")
    public ResponseEntity<String> updateAssignment(@PathVariable Long assignmentId, @RequestBody TeacherSubjectAssignmentRequestDTO update) {
        assignmentService.updateAssignment(assignmentId, update);
        return ResponseEntity.ok("Assignment updated successfully with id = " + assignmentId);
    }

    @DeleteMapping("/assignment/{assignmentId}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return ResponseEntity.ok("Assignment deleted successfully with id = " + assignmentId);
    }
}
