package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Response.RoleResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.RoleService;

@RestController
public class RoleController {

	@Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/roles/{roleId}")
    public RoleResponseDTO getRoleById(@PathVariable Long roleId) {
        return roleService.getRoleById(roleId);
    }
}
