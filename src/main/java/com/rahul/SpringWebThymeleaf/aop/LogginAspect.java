package com.rahul.SpringWebThymeleaf.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogginAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	//execution (* package.*.*.*(..))
	//execution (returnType Package.class.method(..))
	@Before("execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))")
	public void m1Before() {
		logger.info("Before Method Executed ");
	}
	@After("execution (* com.rahul.SpringWebThymeleaf.controller.PersonController.*(..))")
	public void mAfter() {
		logger.info("After the  Method  this method executed Executed ");
	}
}
