package com.ham.main.board;

import java.util.List;

public interface BoardDAO {

	public List<BoardVO> getList() throws Exception;
	
	public int add(BoardVO boardVO) throws Exception;
}
