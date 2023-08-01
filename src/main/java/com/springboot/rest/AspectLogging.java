package com.springboot.rest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {
	public static final Logger LOGGER = LoggerFactory.getLogger(AspectLogging.class);
	@Before("execution(public * com.springboot.rest.AlienController.getAliens())")
	public void logbefore()
	{
		LOGGER.info("Before GetAliens is Called.");
	}
	@After("execution(public * com.springboot.rest.AlienController.getAliens())")//Called irrespective of exception -- after finally.
	public void logafter()
	{
		LOGGER.info("After GetAliens is Called.");
	}
	
	@AfterReturning("execution(public * com.springboot.rest.AlienController.getAliens())")//Called after function call is success.
	public void logafterSuccess()
	{
		LOGGER.info("After GetAliens is Called successfully.");
	}
	
	@AfterThrowing("execution(public * com.springboot.rest.AlienController.getAliens())")//Called after function call throwed exception.
	public void logafterException()
	{
		LOGGER.info("After GetAliens throwed issue.");
	}

}
