package com.yedam.app.board;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	List<Board> findByTitleLike(String title);
	@Query("select b from Board b where b.contents like %?1% or b.title like %?2%")
	List<Board> findContent(String content,String title);
	
	List<Board> findByContentsOrTitle(String content,String title);
}
