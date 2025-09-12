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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.TeacherUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherService;

@RestController
@RequestMapping("/api/admin/teachers")
public class TeacherController {

	@Autowired
    private TeacherService teacherService;

    @PostMapping()
    public ResponseEntity<String> createTeacher(@RequestBody TeacherRequestDTO request) {
        TeacherResponseDTO saved = teacherService.createTeacher(request);
        return ResponseEntity.ok("Teacher created successfully with id = " + saved.getTeacherId());
    }

    @GetMapping("/{teacherId}")
    public TeacherResponseDTO getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @GetMapping()
    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherService.getAllTeacher();
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<String> updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherUpdateDTO update) {
        teacherService.updateTeacher(teacherId, update);
        return ResponseEntity.ok("Teacher updated successfully with id = " + teacherId);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully with id = " + teacherId);
    }
}
