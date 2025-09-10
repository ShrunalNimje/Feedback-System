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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SubjectRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubjectResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.SubjectService;

@RestController
@RequestMapping("/api/teacher/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping()
    public ResponseEntity<String> createSubject(@RequestBody SubjectRequestDTO request) {
        SubjectResponseDTO saved = subjectService.createSubject(request);
        return ResponseEntity.ok("Subject created successfully with id = " + saved.getSubjectId());
    }

    @GetMapping("/{subjectId}")
    public SubjectResponseDTO getSubject(@PathVariable Long subjectId) {
        return subjectService.getSubject(subjectId);
    }

    @GetMapping()
    public List<SubjectResponseDTO> getAllSubjects() {
        return subjectService.getAllSubject();
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<String> updateSubject(@PathVariable Long subjectId, @RequestBody SubjectRequestDTO update) {
        subjectService.updateSubject(subjectId, update);
        return ResponseEntity.ok("Subject updated successfully with id = " + subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Subject deleted successfully with id = " + subjectId);
    }
}
