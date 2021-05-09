package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Board;
import com.example.demo.paging.PageInfo;

public interface BoardService {

	int writeBoard(Board board);

	List<Board> selectBoards(PageInfo pageInfo);

	int selectListCount();

	Board selectBoards(int no);

	int deleteBoard(int no);

}
