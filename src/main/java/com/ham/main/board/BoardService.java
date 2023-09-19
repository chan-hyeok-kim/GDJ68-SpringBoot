package com.ham.main.board;

import java.util.List;

import com.ham.main.commons.Pager;

public interface BoardService {

	 public List<BoardVO> getList(Pager pager) throws Exception;
		
		public int add(BoardVO boardVO) throws Exception;
		
		
		public BoardVO getDetail(BoardVO boardVO) throws Exception;
		
		public int setUpdate(BoardVO boardVO) throws Exception;

		public int setDelete(BoardVO boardVO) throws Exception;
}
