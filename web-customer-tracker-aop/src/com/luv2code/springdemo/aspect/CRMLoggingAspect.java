package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {

	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display the method we are calling
		String theMethodSignature = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @Before: calling	method: " + theMethodSignature);

		// display the arguments to the method
		Object[] args = theJoinPoint.getArgs();

		for (Object aux : args) {
			myLogger.info(aux.toString());
		}
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display the method we are calling
		String theMethodSignature = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @AfterReturning: calling	method: " + theMethodSignature);
		
		//display data returned
		myLogger.info("====>>> result: " + theResult);

	}

}
