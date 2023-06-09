package com.yedam.java.book.service;

import lombok.Data;

@Data
public class BookVO {
//	book_no NUMBER PRIMARY KEY,
//	book_name VARCHAR2(50) NOT NULL,
//	book_coverimg VARCHAR2(20),
//	book_date DATE ,
//	book_price NUMBER,
//	book_publisher VARCHAR2(50),
//	book_info VARCHAR2(2000)
	
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	private String bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	
}
