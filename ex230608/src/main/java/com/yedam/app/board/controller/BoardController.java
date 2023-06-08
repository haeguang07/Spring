package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(Model model, BoardVO boardvo) {
		model.addAttribute("board", boardService.getBoardInfo(boardvo));
		return "board/boardInfo";
	}
	
	
	
	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}
	
	
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardvo) {
		boardService.addBoard(boardvo);
		return "redirect:boardList";
		
		
	}
	
	
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(Model model,BoardVO boardvo) {
		model.addAttribute("board", boardService.getBoardInfo(boardvo)) ;
		return "board/boardUpdate";
	}
	
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdate(BoardVO boardvo) {
		System.out.println(boardvo);
		Map<String, Object> map = new HashMap<>();
		if(boardService.modifyBoard(boardvo)==-1) {
			map.put("result", "Fail");
		}else {
			map.put("result", "Success");
		}
		return map;
		
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(int bno) {
		boardService.removeBoard(bno);
		return "redirect:boardList";
	}
}
