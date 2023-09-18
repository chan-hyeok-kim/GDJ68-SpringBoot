package com.ham.main.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ham.main.board.BoardVO;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	void getListTest() throws Exception {
		List<BoardVO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
		
	}
	@Test
	void addTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardTitle("제목");
		boardVO.setBoardWriter("관리자");
		boardVO.setBoardContents("test");
		int result = noticeDAO.add(boardVO);
		
		assertEquals(1, result);
	}

}
