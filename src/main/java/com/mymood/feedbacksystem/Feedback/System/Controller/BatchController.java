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

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BatchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BatchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.BatchUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.BatchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/batches")
public class BatchController {

	@Autowired
	BatchService batchService;
	
	@PostMapping()
	public ResponseEntity<String> createBatch(@Valid @RequestBody BatchRequestDTO create) {
		BatchResponseDTO saved =  batchService.createBatch(create);
		return ResponseEntity.ok("Batch created successfully with id = " + saved.getBatchId());
	}
	
	@DeleteMapping("/{batchId}")
	public ResponseEntity<String> deleteBatch(@PathVariable Long batchId) {
		batchService.deleteBatch(batchId);
		return ResponseEntity.ok("Batch deleted successfully with id = " + batchId);
	}
	
	@PutMapping("/{batchId}")
	public ResponseEntity<String> updateBatch(@Valid @RequestBody BatchUpdateDTO update, @PathVariable Long batchId) {
		batchService.updateBatch(batchId, update);
		return ResponseEntity.ok("Batch updated successfully with id = " + batchId);
	}
	
	@GetMapping("/{batchId}")
	public BatchResponseDTO getBatch(@PathVariable Long batchId) {
		return batchService.getBatch(batchId);
	}
	
	@GetMapping()
	public List<BatchResponseDTO> getAllBatch() {
		return batchService.getAllBatch();
	}
}
