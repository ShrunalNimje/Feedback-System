package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BranchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BranchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping("/branch")
	public ResponseEntity<String> createBranch(@RequestBody BranchRequestDTO create) {
		BranchResponseDTO saved =  branchService.createBranch(create);
		return ResponseEntity.ok("Branch created successfully with id = " + saved.getBranchId());
	}
	
	@DeleteMapping("/branch/{branchId}")
	public ResponseEntity<String> deleteBranch(@PathVariable Long branchId) {
		branchService.deleteBranch(branchId);
		return ResponseEntity.ok("Branch deleted successfully with id = " + branchId);
	}
	
	@PostMapping("/branch/{branchId}")
	public ResponseEntity<String> updateBranch(@RequestBody BranchRequestDTO update, @PathVariable Long branchId) {
		branchService.updateBranch(branchId, update);
		return ResponseEntity.ok("Branch updated successfully with id = " + branchId);
	}
	
	@GetMapping("/branch/{branchId}")
	public BranchResponseDTO getBranch(@PathVariable Long branchId) {
		return branchService.getBranch(branchId);
	}
	
	@GetMapping("/branch")
	public List<BranchResponseDTO> getAllBranch() {
		return branchService.getAllBranch();
	}
}
