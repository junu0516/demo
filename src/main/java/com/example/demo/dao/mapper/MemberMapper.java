package com.example.demo.dao.mapper;

import com.example.demo.dto.Member;

public interface MemberMapper {
	
	public Member selectMember(String userId);
	public int insertMember(Member member);
	
}
