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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.StudentUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;

@RestController
@RequestMapping("/api/admin/students")
public class StudentController {

	@Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDTO request) {
        StudentResponseDTO saved = studentService.createStudent(request);
        return ResponseEntity.ok("Student created successfully with id = " + saved.getStudentId());
    }

    @GetMapping("/{studentId}")
    public StudentResponseDTO getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping()
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudent();
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody StudentUpdateDTO update) {
    	studentService.updateStudent(studentId, update);
        return ResponseEntity.ok("Student updated successfully with id = " + studentId);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully with id = " + studentId);
    }
}
