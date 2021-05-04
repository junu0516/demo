package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MemberRole;

@Repository
public class MemberRoleDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);
	
	public MemberRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ArrayList<MemberRole> getMemberRoles(String userId){
		
		String sql = "SELECT user_id as userId, role_name as roleName FROM MEMBER_ROLE WHERE USER_ID = :userId";
		HashMap<String,Object> param = new HashMap<>();
		param.put("userId", userId);
		
		return (ArrayList<MemberRole>) jdbc.query(sql, param, rowMapper);
	}
	
}
