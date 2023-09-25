package com.ham.main.board;

import java.util.List;

import com.ham.main.board.notice.NoticeFileVO;
import com.ham.main.commons.Pager;

public interface BoardDAO {

	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public int add(BoardVO boardVO) throws Exception;
	
	public long getCount(Pager pager) throws Exception;
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;

	public int setDelete(BoardVO boardVO) throws Exception;
	
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	public int fileAdd(FileVO fileVO) throws Exception;
	
	public FileVO getFileDetail(FileVO fileVO) throws Exception;
}
