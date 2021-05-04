package com.example.demo.dto;

public class MemberRoleEntity {
	
	private String userId;
	private String roleName;
	
	public MemberRoleEntity() {
		
	}
	
	public MemberRoleEntity(String userId, String roleName) {
		super();
		this.userId = userId;
		this.roleName = roleName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "MemberRoleEntity [userId=" + userId + ", roleName=" + roleName + "]";
	}
	
}
