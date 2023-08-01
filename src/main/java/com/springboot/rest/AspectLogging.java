package com.springboot.rest;

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
	public void log ()
	{
		LOGGER.info("GetAliens is Called.");
	}

}
