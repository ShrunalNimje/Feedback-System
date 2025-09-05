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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SectionRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SectionResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.SectionService;

@RestController
public class SectionController {

	@Autowired
    SectionService sectionService;

    @PostMapping("/section")
    public ResponseEntity<String> createSection(@RequestBody SectionRequestDTO request) {
        SectionResponseDTO saved = sectionService.createSection(request);
        return ResponseEntity.ok("Section created successfully with id = " + saved.getSectionId());
    }

    @GetMapping("/section/{sectionId}")
    public SectionResponseDTO getSection(@PathVariable Long sectionId) {
        return sectionService.getSection(sectionId);
    }

    @GetMapping("/section")
    public List<SectionResponseDTO> getAllSections() {
        return sectionService.getAllSection();
    }

    @PutMapping("section/{sectionId}")
    public ResponseEntity<String> updateSection(@PathVariable Long sectionId, @RequestBody SectionRequestDTO update) {
    	sectionService.updateSection(sectionId, update);
        return ResponseEntity.ok("Section updated successfully with id = " + sectionId);
    }

    @DeleteMapping("/section/{sectionId}")
    public ResponseEntity<String> deleteSection(@PathVariable Long sectionId) {
        sectionService.deleteSection(sectionId);
        return ResponseEntity.ok("Section deleted successfully with id = " + sectionId);
    }
}
