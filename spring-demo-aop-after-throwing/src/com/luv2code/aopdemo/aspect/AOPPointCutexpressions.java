package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPPointCutexpressions {
	
	/*this is where we add all of our related advice for logging
	let's start with an @Before advice
	 ***********************************/
	
	//Creating point-cut declaration.
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create point-cut for setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forGetter() {}
	
	//create point-cut for getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forSetter() {}
	
	//create point-cut : Include all methods but exclude both getter & setter method
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void forCombined() {}

}
