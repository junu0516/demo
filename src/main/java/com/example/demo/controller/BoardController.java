package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//게시글 리스트로 이동
	@GetMapping("/list.bo")
	public String showBoardList() {
		
		return "board/boardList";
	}
	
	//게시글 등록
	@PostMapping("/write")
	public String writeBoard(Board board) throws Exception {
		System.out.println(board);
		
		//게시글 작성날짜, 수정날짜 입력
		board.setCreateDate(LocalDate.now().toString());
		board.setModifyDate(board.getCreateDate());
		
		int result = boardService.writeBoard(board);
		if(result<0) {
			throw new Exception("Writing Error");
		}
		
		return "redirect:main";
	}
}
