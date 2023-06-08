package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.board.service.BoardService;

@RestController
public class BoardRestController {
	@Autowired
	BoardService Boardservice;
	
}
