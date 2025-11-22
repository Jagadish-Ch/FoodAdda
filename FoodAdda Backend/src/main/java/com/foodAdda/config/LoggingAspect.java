package com.foodAdda.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	
	@Before("execution(* com.foddAdda.service.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("before Method will start now : Info is coming from Aspect class"+ " "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.foddAdda.service.*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("after Method ended now : Info is coming from Aspect class" + " "+joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.foddAdda.service.*.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("Method executed successfully: " +joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(* com.foddAdda.service.*.*(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("Exception in method: "+ joinPoint.getSignature().getName());
		System.out.println("Exception Message: " + ex.getMessage());
	}
}
