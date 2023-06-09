package com.yedam.java.book.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	//등록 페이지
	@GetMapping("bookInsert")
	public String bookInsert(Model model) {
		model.addAttribute("bookNo", bookService.getNewBookNo());
		return "book/bookInsert";
	}
	//목록조회/수정 페이지
	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("bookList", bookService.getBookList());
		return "book/bookList";
	}
	
	
	//대여현황 조회 페이지 
	@GetMapping("rentList")
	public String rentList(Model model) {
		model.addAttribute("rentList", bookService.getRentList());
		return "book/rentList";
	}
	
	//등록 기능
	@PostMapping("bookInsert")
	@ResponseBody
	public Map<String, Object> bookInsert(@RequestBody BookVO vo) {
		Map<String, Object> map = new HashMap<>();
		int result = bookService.addBook(vo);
		if(result==1) {
			map.put("result", "Success");
		}else {
			map.put("result", "Fail");			
		}
		return map;
	}
}
