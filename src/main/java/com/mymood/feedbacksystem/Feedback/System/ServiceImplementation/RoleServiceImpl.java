package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.RoleResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.RoleEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.RoleRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
    RoleRepository roleRepository;
	
	@Override
	public List<RoleResponseDTO> getAllRoles() {
		
		return roleRepository.findAll()
                .stream()
                .map(role -> new RoleResponseDTO(
                        role.getRoleId(),
                        role.getName().name()))
                .collect(Collectors.toList());
	}

	@Override
	public RoleResponseDTO getRoleById(Long roleId) {
		
		RoleEntity role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));
        
		return new RoleResponseDTO(role.getRoleId(), role.getName().name());
	}

}
