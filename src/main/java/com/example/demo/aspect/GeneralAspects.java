package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class GeneralAspects{
	
	
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	public void LoggingPointCut() {}
	
	@AfterThrowing(value = "execution(* com.example.demo.controller.*.*(..))", throwing = "ex")
	public void AfterExcp(JoinPoint joinpoint, Exception ex)
	{
		log.info("After Method Invoked :: " + ex.getMessage());
	}
}
