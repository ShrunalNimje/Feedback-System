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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BranchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BranchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.BranchService;

@RestController
@RequestMapping("/api/admin/branches")
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping()
	public ResponseEntity<String> createBranch(@RequestBody BranchRequestDTO create) {
		BranchResponseDTO saved =  branchService.createBranch(create);
		return ResponseEntity.ok("Branch created successfully with id = " + saved.getBranchId());
	}
	
	@DeleteMapping("/{branchId}")
	public ResponseEntity<String> deleteBranch(@PathVariable Long branchId) {
		branchService.deleteBranch(branchId);
		return ResponseEntity.ok("Branch deleted successfully with id = " + branchId);
	}
	
	@PutMapping("/{branchId}")
	public ResponseEntity<String> updateBranch(@RequestBody BranchRequestDTO update, @PathVariable Long branchId) {
		branchService.updateBranch(branchId, update);
		return ResponseEntity.ok("Branch updated successfully with id = " + branchId);
	}
	
	@GetMapping("/{branchId}")
	public BranchResponseDTO getBranch(@PathVariable Long branchId) {
		return branchService.getBranch(branchId);
	}
	
	@GetMapping()
	public List<BranchResponseDTO> getAllBranch() {
		return branchService.getAllBranch();
	}
}
