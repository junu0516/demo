package com.example.demo.dto;

public class MemberRole {
	
	private int no;
	private String userId;
	private String roleName;
	
	public MemberRole() {
		
	}

	public MemberRole(int no, String userId, String roleName) {
		super();
		this.no = no;
		this.userId = userId;
		this.roleName = roleName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
		return "MemberRole [no=" + no + ", userId=" + userId + ", roleName=" + roleName + "]";
	}

}
