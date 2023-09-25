package com.ham.main.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestScheduler {

	//특정 주기로 메서드 반복
	@Scheduled(fixedDelay = 1000)
	public void useFixed() throws Exception{
		log.info("====== Fixed Schedule ========");
		
	}
	
	
}
