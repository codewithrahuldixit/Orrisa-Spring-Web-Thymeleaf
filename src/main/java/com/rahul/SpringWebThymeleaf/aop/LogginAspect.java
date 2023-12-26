package com.rahul.SpringWebThymeleaf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // [A Combination of 1: Advice & 2: Pointcut ][what to do & When to do]

@Configuration
public class LogginAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// execution (* package.*.*.*(..))
	// execution (returnType Package.class.method(..))
	/*
	 * @Before("execution (* com.rahul.SpringWebThymeleaf.controller.*.*(..))")
	 * public void m1Before() { logger.info("Before Method Executed "); }
	 * 
	 * @After("execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))"
	 * ) public void mAfter() {
	 * logger.info("After the  Method Execute Always this method executed Executed "
	 * ); }
	 * 
	 * @AfterThrowing( pointcut =
	 * "execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))"
	 * , throwing = "exception" ) public void logMethodCallAfterException(JoinPoint
	 * joinPoint, Exception exception) {
	 * logger.info("AfterThrowing Aspect - {} has thrown an exception {}" ,
	 * joinPoint, exception); }
	 * 
	 * @AfterReturning( pointcut =
	 * "execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))"
	 * , returning = "resultValue" ) public void
	 * logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object
	 * resultValue) { logger.info("AfterReturning Aspect - {} has returned {}" ,
	 * joinPoint, resultValue); }
	 * 
	 * 
	 * @Around("execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))"
	 * ) // ProceedingJoinPoint : used to Proceed the method public Object
	 * findExecutionTime(ProceedingJoinPoint proceedingJoinPoint, JoinPoint
	 * joinpoint) throws Throwable { //Start a timer long startTimeMillis =
	 * System.currentTimeMillis(); //Execute the method Object returnValue =
	 * proceedingJoinPoint.proceed(); //Stop the timer long stopTimeMillis =
	 * System.currentTimeMillis(); long executionDuration = stopTimeMillis -
	 * startTimeMillis; logger.info("Around Aspect - {} Method executed in {} ms",
	 * proceedingJoinPoint, executionDuration);
	 * //logger.info("With Follwing argument {}",joinpoint.getArgs()); return
	 * returnValue; }
	 */
	@Before("execution (* com.rahul.SpringWebThymeleaf.controller.*.*(..))")
	public void m1Before(JoinPoint joinPoint) {
		logger.info("Before Method Executed {}  with arguments {}",joinPoint,joinPoint.getArgs());
	}

}
