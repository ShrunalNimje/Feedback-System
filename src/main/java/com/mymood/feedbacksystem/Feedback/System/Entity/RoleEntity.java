package com.mymood.feedbacksystem.Feedback.System.Entity;

import com.mymood.feedbacksystem.Feedback.System.Enum.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	@Column(nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private Role name;
	
	public RoleEntity() {
		
	}
	
	public RoleEntity(Long roleId, Role name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Role getName() {
		return name;
	}

	public void setName(Role name) {
		this.name = name;
	}
	
}
