package com.ham.main.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.ham.main.board.BoardVO;
import com.ham.main.commons.Pager;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	

	
//	@Test
	void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.setStartRow(0L);
		pager.setLastRow(10L);
		pager.setKind("1");
		pager.setSearch("20");
		List<BoardVO> ar = noticeDAO.getList(pager);
		assertEquals(2, ar.size());
		
	}
//	@Test
	void addTest() throws Exception {
		for(int i=0; i<150; i++) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardTitle("제목"+i);
		boardVO.setBoardWriter("관리자"+i);
		boardVO.setBoardContents("test"+i);
		int result = noticeDAO.add(boardVO);
		
		if(i%10==0) {
	    	Thread.sleep(500);
		    }
		}
		System.out.println("Finish");
	}
	
//	@Test
    void getCount() throws Exception{
    	Pager pager = new Pager();
    	pager.setKind("1");
    	pager.setSearch("20");
    	Long count = noticeDAO.getCount(pager);
    	assertEquals(2L, count);
    }

//	@Test
	void getDetail(BoardVO boardVO) throws Exception{
		boardVO.setBoardNo(2L);
		
		boardVO = noticeDAO.getDetail(boardVO);
		assertNotNull(boardVO);
	}
	
//	@Test
	void setUpdate(BoardVO boardVO) throws Exception{
		boardVO.setBoardContents("내용 변경");
		boardVO.setBoardNo(2L);
		
		int result = noticeDAO.setUpdate(boardVO);
		assertEquals(1, result);
	}
	
//	@Test
	void setDelete(BoardVO boardVO) throws Exception{
		boardVO.setBoardNo(3L);
		
		int result = noticeDAO.setDelete(boardVO);
		assertEquals(1, result);
	}
	
//	@Test
	void setHitUpdate(BoardVO boardVO) throws Exception{
		boardVO.setBoardNo(2L);
		
		int result = noticeDAO.setHitUpdate(boardVO);
		assertEquals(1, result);
	}
	
}
