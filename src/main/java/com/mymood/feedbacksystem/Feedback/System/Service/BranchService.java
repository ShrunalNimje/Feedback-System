package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BranchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BranchResponseDTO;

public interface BranchService {
	
	BranchResponseDTO createBranch(BranchRequestDTO create);
	void deleteBranch(Long id);
	BranchResponseDTO updateBranch(Long id, BranchRequestDTO update);
	List<BranchResponseDTO> getAllBranch();
	BranchResponseDTO getBranch(Long id);

}
