package com.ham.main.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ham.main.board.BoardVO;
import com.ham.main.board.notice.NoticeDAO;
import com.ham.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestScheduler {

	@Autowired
	private NoticeDAO noticeDAO;
	
	
	//특정 주기로 메서드 반복
	//@Scheduled(fixedDelay = 1000)
	public void useFixed() throws Exception{
		log.info("====== Fixed Schedule ========");
		
	}
	
	//@Scheduled(fixedRateString = "2000", initialDelayString = "1000") //fixedRate=2000
	public void userFixDelay() throws Exception{
		
		log.info("===== Fixed Rate =========");
		
	}
	
	//@Scheduled(cron = "*/10 * * * * *")
	public void useCron() throws Exception{
		Pager pager = new Pager();
		List<BoardVO> bl = noticeDAO.getList(pager);
		log.info("List: {}", bl);
		
		
		
	}
	
	
}
