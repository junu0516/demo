package com.example.demo.dao.mapper;

import java.util.List;

import com.example.demo.dto.MemberRole;

public interface MemberRoleMapper {
	
	public List<MemberRole> selectMemberRole(String userId);
}
