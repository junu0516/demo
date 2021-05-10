package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Board;
import com.example.demo.paging.PageInfo;
import com.example.demo.paging.Pagination;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//게시글 리스트로 이동
	@GetMapping("/list")
	public String showBoardList(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		System.out.println("page : "+page);
		int listCount = boardService.selectListCount();
		
		PageInfo pageInfo = Pagination.getPageInfo(listCount, page, 5, 5);
		model.addAttribute("pageInfo",pageInfo);
		
		List<Board> boards = boardService.selectBoards(pageInfo);
		model.addAttribute("boards",boards);
		
		return "board/boardList";
	}
	
	//게시글 등록
	@PostMapping("/write")
	public String writeBoard(Board board) throws Exception {
		System.out.println(board);
		
		//게시글 작성날짜, 수정날짜 입력
		board.setCreateDate(new Timestamp(System.currentTimeMillis()));
		board.setModifyDate(new Timestamp(System.currentTimeMillis()));
		
		int result = boardService.writeBoard(board);
		if(result<0) {
			throw new Exception("Writing Error");
		}
		
		return "redirect:/board/list";
	}
	
	//게시글 상세조회
	@GetMapping("/detail")
	public String showBoardDetail(@RequestParam(required=true)int no, Model model) {
				
		Board board = boardService.selectBoards(no);
		model.addAttribute("board", board);
		
		return "board/boardDetail";
	}
	
	//수정 폼으로 이동
	@GetMapping("/modify")
	public String showUpdateForm(@RequestParam(required=true)int no, Model model) {
		
		Board board = boardService.selectBoards(no);
		model.addAttribute("board",board);
		
		return "board/boardUpdate";
	}
	
	//게시글 수정
	@PutMapping("/{no}")
	@ResponseBody
	public String updateBoard(@PathVariable int no, String title, String content) throws Exception {
		
		HashMap<String,Object> param = new HashMap<>();
		param.put("no", String.valueOf(no));
		param.put("title", title);
		param.put("content", content);
		param.put("modifyDate", new Timestamp(System.currentTimeMillis()));
		
		int result = boardService.updateBoard(param);
		if(result<0) {
			throw new Exception("Update Error");
		}
		
		return null;
	}
	
	//게시글 삭제
	@DeleteMapping("/{no}")
	@ResponseBody
	public String deleteBoard(@PathVariable int no) throws Exception {
	
		int result = boardService.deleteBoard(no);
		if(result<0) {
			throw new Exception("Delete Error");
		}
		
		return null;
	}
	
}
