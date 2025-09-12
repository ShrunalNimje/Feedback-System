package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BatchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BatchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.BatchUpdateDTO;

public interface BatchService {

	BatchResponseDTO createBatch(BatchRequestDTO create);
	void deleteBatch(Long id);
	BatchResponseDTO updateBatch(Long id, BatchUpdateDTO update);
	List<BatchResponseDTO> getAllBatch();
	BatchResponseDTO getBatch(Long id);
}
