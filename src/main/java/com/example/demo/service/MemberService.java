package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.dto.Member;
import com.example.demo.dto.MemberEntity;
import com.example.demo.dto.MemberRoleEntity;

public interface MemberService {

	public MemberEntity getMember(String userId);

	public ArrayList<MemberRoleEntity> getMemberRoles(String userId);

	public void enroll(Member member) throws Exception;
	
}
