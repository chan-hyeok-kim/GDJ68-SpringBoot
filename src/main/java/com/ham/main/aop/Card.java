package com.ham.main.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Card {

	@Around("execution(* com.ham.main.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
//		메서드를 객체화시킨 것이 joinPoint
		log.info("===================");
		log.info("Card Check 타기");
		
		Object[] args = joinPoint.getArgs();
		log.info("Args : {}",args);
		Object obj = joinPoint.proceed();
		
		log.info("Card Check 내리기");
		log.info("===================");
		
		return obj;
	}
}
