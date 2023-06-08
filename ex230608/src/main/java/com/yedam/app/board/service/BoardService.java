package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 전체
	public List<BoardVO> getBoardList();

	// 단건
	public BoardVO getBoardInfo(BoardVO boardvo);

	// 등록
	public int addBoard(BoardVO boardvo);

	// 수정
	public int modifyBoard(BoardVO boardvo);

	// 삭제
	public int removeBoard(int boardNo);
}
