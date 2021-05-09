package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.Board;
import com.example.demo.paging.PageInfo;
import com.example.demo.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public int writeBoard(Board board) {
		
		int result = boardDao.writeBoard(board);
		
		return result;
	}

	@Override
	public List<Board> selectBoards(PageInfo pageInfo) {
		
		return boardDao.selectBoards(pageInfo);
	}

	@Override
	public int selectListCount() {
		
		return boardDao.selectListCount();
	}

	@Override
	public Board selectBoards(int no) {
		
		return boardDao.selectBoard(no);
	}

	@Override
	public int deleteBoard(int no){
		
		
		return boardDao.deleteBoard(no);
	}

}
