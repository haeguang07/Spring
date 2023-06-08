package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardvo) {
		
		return boardMapper.selectBoardInfo(boardvo);
	}

	@Override
	public int addBoard(BoardVO boardvo) {
		int result = -1;
		if(boardMapper.insertBoard(boardvo)==1) {
			result= boardvo.getBno();
		}
		return result;
	}

	@Override
	public int modifyBoard(BoardVO boardvo) {
		int result = -1;
		if(boardMapper.updateBoard(boardvo)==1) {
			result= boardvo.getBno();
		}
		return result;
	}

	@Override
	public int removeBoard(int bno) {
		int result = -1;
		if(boardMapper.deleteBoard(bno)>0) {
			result= bno;
		}
		return result;
	}

}
