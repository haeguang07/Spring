package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class BoardVO {
//    bno NUMBER PRIMARY KEY,
//    "title" VARCHAR2(1000) NOT NULL,
//    "contents" VARCHAR2(4000) NOT NULL,
//    writer VARCHAR2(1000) NOT NULL,
//    regdate DATE DEFAULT sysdate NOT NULL ,
//    updatedate DATE DEFAULT sysdate,
//    image VARCHAR2(4000)
	
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;
	private String image;

	
}
