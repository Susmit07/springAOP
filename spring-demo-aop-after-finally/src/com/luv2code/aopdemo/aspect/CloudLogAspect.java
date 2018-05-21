package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // @Order - Guarantees order of execution of aspects by Spring.
public class CloudLogAspect {

	@Before("com.luv2code.aopdemo.aspect.AOPPointCutexpressions.forCombined()")
	public void addToCloud() {
		System.out.println("\n=====>>> Logging to cloud");		
	}
}
