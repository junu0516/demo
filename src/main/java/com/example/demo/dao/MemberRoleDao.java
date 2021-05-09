package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.MemberRoleMapper;
import com.example.demo.dto.MemberRole;

@Repository
public class MemberRoleDao {
	
	@Autowired
	MemberRoleMapper memberRoleMapper;
	
	public List<MemberRole> getMemberRoles(String userId){
		
		return memberRoleMapper.selectMemberRole(userId);
	}
	
	/*
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);
	
	public MemberRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<MemberRole> getMemberRoles(String userId){
		
		String sql = "SELECT user_id as userId, role_name as roleName FROM MEMBER_ROLE WHERE USER_ID = :userId";
		HashMap<String,Object> param = new HashMap<>();
		param.put("userId", userId);
		
		return jdbc.query(sql, param, rowMapper);
	}
	
	*/
	
}
