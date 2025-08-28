package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.DepartmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.DepartmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO create) {
		
		DepartmentEntity dept = new DepartmentEntity();
		dept.setName(create.getName());
		
		DepartmentEntity saved = departmentRepository.save(dept);
		return new DepartmentResponseDTO(saved.getDepartmentId(), saved.getName());
	}

	@Override
	public void deleteDepartment(Long id) {
		
		departmentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Department not exist!"));
		
		departmentRepository.deleteById(id);
	}

	@Override
	public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO update) {
		
		DepartmentEntity existingDepartment = departmentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Department not exist!"));
		
		existingDepartment.setName(update.getName());
		DepartmentEntity saved = departmentRepository.save(existingDepartment);
		return new DepartmentResponseDTO(id, saved.getName());
	}

	@Override
	public List<DepartmentResponseDTO> getAllDepartment() {
		return departmentRepository.findAll().stream().map(
				dept -> new DepartmentResponseDTO(dept.getDepartmentId(), dept.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentResponseDTO getDepartment(Long id) {
		
		DepartmentEntity dept = departmentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Department not exist!"));
		
		return new DepartmentResponseDTO(id, dept.getName());
	}

}
