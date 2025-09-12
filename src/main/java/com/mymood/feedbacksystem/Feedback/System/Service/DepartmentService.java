package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.DepartmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.DepartmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.DepartmentUpdateDTO;

public interface DepartmentService {

	DepartmentResponseDTO createDepartment(DepartmentRequestDTO create);
	void deleteDepartment(Long id);
	DepartmentResponseDTO updateDepartment(Long id, DepartmentUpdateDTO update);
	List<DepartmentResponseDTO> getAllDepartment();
	DepartmentResponseDTO getDepartment(Long id);
	
}
