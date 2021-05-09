package com.example.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.example.demo.dto.Board;

public interface BoardMapper {

	 public int insertBoard(Board board);

	public List<Board> selectBoards();

	public int selectListCount();

	public List<Board> selectBoards(RowBounds rowBounds);

	public Board selectBoard(int no);

	public int deleteBoard(int no);
}
