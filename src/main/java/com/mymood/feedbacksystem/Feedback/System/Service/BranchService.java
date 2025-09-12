package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BranchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BranchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.BranchUpdateDTO;

public interface BranchService {
	
	BranchResponseDTO createBranch(BranchRequestDTO create);
	void deleteBranch(Long id);
	BranchResponseDTO updateBranch(Long id, BranchUpdateDTO update);
	List<BranchResponseDTO> getAllBranch();
	BranchResponseDTO getBranch(Long id);

}
