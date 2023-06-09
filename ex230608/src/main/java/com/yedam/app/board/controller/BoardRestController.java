package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@RestController
public class BoardRestController {
	@Autowired
	BoardService boardService;

	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boards")
	public  Map<String, Object> boardInsert(@RequestBody BoardVO boardvo) {
		Map<String, Object> map = new HashMap<>();
		if (boardService.addBoard(boardvo) > -1) {
			map.put("result", "Success");
			map.put("bno", boardvo.getBno());
		} else {
			map.put("result", "Fail");
		}
		return map;
	}

	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PutMapping("boards")
	public Map<String, Object> boardUpdate(@RequestBody BoardVO boardvo) {
		System.out.println(boardvo);
		Map<String, Object> map = new HashMap<>();
		if (boardService.modifyBoard(boardvo) > -1) {
			map.put("result", "Success");
		} else {
			map.put("result", "Fail");
		}
		return map;
	}
}
