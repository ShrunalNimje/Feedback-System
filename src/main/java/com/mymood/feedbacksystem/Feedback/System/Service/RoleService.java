package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.RoleResponseDTO;

public interface RoleService {

	List<RoleResponseDTO> getAllRoles();
    RoleResponseDTO getRoleById(Long roleId);
}
