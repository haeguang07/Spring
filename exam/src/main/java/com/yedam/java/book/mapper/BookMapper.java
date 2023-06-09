package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	public int selectNewBookNo();
	public int insertBook(BookVO vo);
	public List<BookVO> selectBookList();
	public List<RentVO> selectRentList();
	
}
