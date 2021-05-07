package com.example.demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.MemberMapper;
import com.example.demo.dto.Member;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@Repository
public class MemberDao {
	
	@Autowired
	MemberMapper memberMapper;

	public Member getMember(String userId) {
		
		return memberMapper.selectMember(userId);
	}

	public int insertMemberInfo(Member member) {
		
		return memberMapper.insertMember(member);
	}
	
	
	/*
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
	private SimpleJdbcInsert memberInsertion;
	private SimpleJdbcInsert memberRoleInsertion;
	
	public MemberDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.memberInsertion = new SimpleJdbcInsert(dataSource).withTableName("member");
		this.memberRoleInsertion = new SimpleJdbcInsert(dataSource).withTableName("member_role");
	}

	public Member getMember(String userId) {
		System.out.println("MemberDao / userId : "+userId);
		String sql = "select user_id as id, user_pwd as pwd, user_name as name from member where user_id = :userId";
		HashMap<String,String> param = new HashMap<>();
		param.put("userId", userId);
		
		return jdbc.queryForObject(sql, param, rowMapper);
	}

	public int insertMemberInfo(Member member) {
		
		//회원정보 등록
		HashMap<String,Object> param = new HashMap<>();
		param.put("user_id", member.getId());
		param.put("user_pwd", member.getPwd());
		param.put("user_name", member.getName());
		
		int result1 = memberInsertion.execute(param);
		
		//회원 권한정보 등록
		param = new HashMap<>();
		param.put("user_id",member.getId());
		param.put("role_name", "ROLE_USER");
		
		int result2 = memberRoleInsertion.execute(param);
		
		return result1 * result2;
	}
	*/
}
