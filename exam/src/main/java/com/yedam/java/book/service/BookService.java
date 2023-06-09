package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public int getNewBookNo();
	public int addBook(BookVO vo);
	public List<BookVO> getBookList();
	public List<RentVO> getRentList();
}
