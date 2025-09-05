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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BatchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BatchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.BatchService;

@RestController
public class BatchController {

	@Autowired
	BatchService batchService;
	
	@PostMapping("/batch")
	public ResponseEntity<String> createBatch(@RequestBody BatchRequestDTO create) {
		BatchResponseDTO saved =  batchService.createBatch(create);
		return ResponseEntity.ok("Batch created successfully with id = " + saved.getBatchId());
	}
	
	@DeleteMapping("/batch/{batchId}")
	public ResponseEntity<String> deleteBatch(@PathVariable Long batchId) {
		batchService.deleteBatch(batchId);
		return ResponseEntity.ok("Batch deleted successfully with id = " + batchId);
	}
	
	@PostMapping("/batch/{batchId}")
	public ResponseEntity<String> updateBatch(@RequestBody BatchRequestDTO update, @PathVariable Long batchId) {
		batchService.updateBatch(batchId, update);
		return ResponseEntity.ok("Batch updated successfully with id = " + batchId);
	}
	
	@GetMapping("/batch/{batchId}")
	public BatchResponseDTO getBatch(@PathVariable Long batchId) {
		return batchService.getBatch(batchId);
	}
	
	@GetMapping("/batch")
	public List<BatchResponseDTO> getAllBatch() {
		return batchService.getAllBatch();
	}
}
