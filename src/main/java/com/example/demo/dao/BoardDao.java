package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.mapper.BoardMapper;
import com.example.demo.dto.Board;
import com.example.demo.paging.PageInfo;

@Repository	
public class BoardDao {

	@Autowired
	BoardMapper boardMapper;
	
	public int writeBoard(Board board) {
		
		return boardMapper.insertBoard(board);
	}

	public List<Board> selectBoards(PageInfo pageInfo) {
		
		int offset = (pageInfo.getCurrentPage()-1)*pageInfo.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset,pageInfo.getBoardLimit());
		
		return boardMapper.selectBoards(rowBounds);
	}

	public int selectListCount() {
		
		return boardMapper.selectListCount();
	}

	public Board selectBoard(int no) {
		
		return boardMapper.selectBoard(no);
	}

	public int deleteBoard(int no) {
		
		return boardMapper.deleteBoard(no);
	}

	public int updateBoard(HashMap<String, Object> param) {
		
		return boardMapper.updateBoard(param);
	}
}
