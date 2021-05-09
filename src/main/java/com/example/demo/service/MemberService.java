package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Member;
import com.example.demo.dto.MemberEntity;
import com.example.demo.dto.MemberRoleEntity;

public interface MemberService {

	public MemberEntity getMember(String userId);

	public List<MemberRoleEntity> getMemberRoles(String userId);

	public void enroll(Member member) throws Exception;
	
}
