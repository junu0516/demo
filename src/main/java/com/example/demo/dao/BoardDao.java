package com.example.demo.dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Board;

@Repository
public class BoardDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
	private SimpleJdbcInsert boardInsertion;
	
	public BoardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.boardInsertion = new SimpleJdbcInsert(dataSource).withTableName("board");
	}
	
	public int writeBoard(Board board) {
		
		HashMap<String,Object> param = new HashMap<>();
		param.put("title", board.getTitle());
		param.put("writer", board.getWriter());
		param.put("content", board.getContent());
		param.put("create_date", board.getCreateDate());
		param.put("modify_date", board.getModifyDate());
		param.put("count", 0); //default value : 0
		
		return 0;
	}

}
