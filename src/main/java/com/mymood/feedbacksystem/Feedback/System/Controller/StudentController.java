package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.StudentUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/students")
public class StudentController {

	@Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequestDTO request) {
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
    public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @Valid @RequestBody StudentUpdateDTO update) {
    	studentService.updateStudent(studentId, update);
        return ResponseEntity.ok("Student updated successfully with id = " + studentId);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully with id = " + studentId);
    }
    
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
//    	if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please upload a valid CSV file");
//        }
//    	
//    	try {
//            studentService.saveStudentsFromCSV(file);
//            return ResponseEntity.ok("CSV uploaded and students saved successfully.");
//        } 
//    	catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error while processing CSV: " + e.getMessage());
//        }
//    }
    
}
