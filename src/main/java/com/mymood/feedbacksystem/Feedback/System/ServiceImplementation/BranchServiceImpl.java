package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BranchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BranchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.BranchUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BranchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.BranchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public BranchResponseDTO createBranch(BranchRequestDTO create) {
		
		if (branchRepository.existsByName(create.getName())) {
		    throw new RuntimeException("Branch already exists");
		}

		DepartmentEntity dept = departmentRepository.findById(create.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("Department not found!"));
		
		BranchEntity branch = new BranchEntity();
		branch.setName(create.getName());
		branch.setDepartment(dept);
		
		BranchEntity saved = branchRepository.save(branch);
		return new BranchResponseDTO(saved.getBranchId(), saved.getName(), dept.getName());	
	}

	@Override
	public void deleteBranch(Long id) {
		
		branchRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Branch not found!"));
		
		branchRepository.deleteById(id);
	}

	@Override
	public BranchResponseDTO updateBranch(Long id, BranchUpdateDTO update) {
		
		BranchEntity existingBranch = branchRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Branch not found!"));
		
		if (update.getName() != null) {
		    if (branchRepository.existsByName(update.getName())
		            && !existingBranch.getName().equals(update.getName())) {
		        throw new RuntimeException("Another branch with this name already exists");
		    }
		    existingBranch.setName(update.getName());
		}

		if(update.getDepartmentId() != null) {
			DepartmentEntity dept = departmentRepository.findById(update.getDepartmentId())
					.orElseThrow(() -> new RuntimeException("Department not found!"));
			
			existingBranch.setDepartment(dept);
		}
		
		BranchEntity saved = branchRepository.save(existingBranch);
		return new BranchResponseDTO(id, saved.getName(), saved.getDepartment().getName());	
		
	}

	@Override
	public List<BranchResponseDTO> getAllBranch() {
		return branchRepository.findAll()
				.stream()
				.map(branch -> new BranchResponseDTO(
						branch.getBranchId(), 
						branch.getName(), 
						branch.getDepartment().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public BranchResponseDTO getBranch(Long id) {
		
		BranchEntity branch = branchRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Branch not found!"));
		
		return new BranchResponseDTO(id, branch.getName(), branch.getDepartment().getName());
		
	}

}
