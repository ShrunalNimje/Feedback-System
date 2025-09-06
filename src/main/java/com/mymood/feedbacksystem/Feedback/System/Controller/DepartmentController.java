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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.DepartmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.DepartmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/department")
	public ResponseEntity<String> createDepartment(@RequestBody DepartmentRequestDTO create) {
		DepartmentResponseDTO saved =  departmentService.createDepartment(create);
		return ResponseEntity.ok("Department created successfully with id = " + saved.getDepartmentId());
	}
	
	@DeleteMapping("/department/{departmentId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department deleted successfully with id = " + departmentId);
	}
	
	@PutMapping("/department/{departmentId}")
	public ResponseEntity<String> updateDepartment(@RequestBody DepartmentRequestDTO update, @PathVariable Long departmentId) {
		departmentService.updateDepartment(departmentId, update);
		return ResponseEntity.ok("Department updated successfully with id = " + departmentId);
	}
	
	@GetMapping("/department/{departmentId}")
	public DepartmentResponseDTO getDepartment(@PathVariable Long departmentId) {
		return departmentService.getDepartment(departmentId);
	}
	
	@GetMapping("/department")
	public List<DepartmentResponseDTO> getAllDepartment() {
		return departmentService.getAllDepartment();
	}
}
