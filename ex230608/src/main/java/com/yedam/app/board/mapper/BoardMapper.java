package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체
	public List<BoardVO> selectBoardList();

	// 단건
	public BoardVO selectBoardInfo(BoardVO boardvo);

	// 등록
	public int insertBoard(BoardVO boardvo);

	// 수정
	public int updateBoard(BoardVO boardvo);

	// 삭제
	public int deleteBoard(int bno);
}
