package com.ham.main.aop;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Transfer {

	
	public void useBus(String number) {
		log.info(" 버스 타기 ");
	}
	
	public void useSubway(String number) {
		log.info(" 지하철 타기");
	}
	
}
