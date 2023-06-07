package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	//포이트컷 : join포인트(비즈니스 로직과 관련돤 메소드) 안에서 Advice(공통코드)가 적용될 메소드
	@Pointcut("within(com.yedam.app.aop.*)")
	public void allPointCut() {}
	
	
	
	//Weaving: 포인트컷 + Advice + 동작시점
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable{
		//Aop가 적용되는 메서드의 이름
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("시작: " +signatureStr);
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능: "+ System.currentTimeMillis());
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			//공통기능
			System.out.println("핵심 기능 후 실행 - 공통기능: " + System.currentTimeMillis());
		}
	}
	
	
}
