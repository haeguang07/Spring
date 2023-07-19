package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.board.Board;
import com.yedam.app.board.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	
	@Autowired
	private BoardRepository boardRepository;
	
	//@Test
	public void insert() {
		Board b1 = Board.builder()
						.writer("test")
						.title("title")
						.contents("content")
						.regdate(new Date())
						.build();
		boardRepository.save(b1);
	
		Board b2 = boardRepository.findById(b1.getBno()).get();
		System.out.println(b1);
		System.out.println(b2);
		assertEquals(b1.getTitle(), b2.getTitle());
	}
	@Test
	public void list() {
		//Iterable<Board> list = boardRepository.findByTitleLike("%ti%");
		Iterable<Board> list = boardRepository.findContent("co","ti");
		System.out.println(list);
	}
	
	@Test
	public void update() {
		
	}
	
}
