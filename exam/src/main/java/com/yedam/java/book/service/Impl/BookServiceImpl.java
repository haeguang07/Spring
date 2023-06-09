package com.yedam.java.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public int getNewBookNo() {
		return bookMapper.selectNewBookNo();
	}

	@Override
	public int addBook(BookVO vo) {
		return bookMapper.insertBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		return bookMapper.selectBookList();
	}

	@Override
	public List<RentVO> getRentList() {
		return bookMapper.selectRentList();
	}

}
