package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.MemberRoleDao;
import com.example.demo.dto.Member;
import com.example.demo.dto.MemberEntity;
import com.example.demo.dto.MemberRole;
import com.example.demo.dto.MemberRoleEntity;
import com.example.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberRoleDao memberRoleDao;
	
	@Override
	public MemberEntity getMember(String userId) {
		
		Member member = memberDao.getMember(userId);
		System.out.println(member);
		return new MemberEntity(member.getId(), member.getPwd());
	}

	@Override
	public ArrayList<MemberRoleEntity> getMemberRoles(String userId) {
		
		ArrayList<MemberRole> memberRoles = memberRoleDao.getMemberRoles(userId);
		ArrayList<MemberRoleEntity> memberRoleEntities = new ArrayList<>();
		
		for(MemberRole memberRole : memberRoles) {
			memberRoleEntities.add(new MemberRoleEntity(userId,memberRole.getRoleName()));
		}
		
		return memberRoleEntities;
	}

	@Override
	@Transactional
	public int insertMemberInfo(Member member) {
		
		return memberDao.insertMemberInfo(member);
	}

}
