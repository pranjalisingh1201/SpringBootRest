package com.springboot.rest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {
	
	@Before("execution(public * com.springboot.rest.AlienController.getAliens())")
	public void log ()
	{
		System.out.println("GetAliens is Called.");
	}

}
