package com.javi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* com.javi.aopdemo.dao.*.*(..))")//create pointcut declaration
	public void forDaoPackage() {
		
	}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.javi.aopdemo.dao.*.get*(..))")//match getter methods
	public void getter() {}
	
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.javi.aopdemo.dao.*.set*(..))")//match setter methods
	public void setter() {}
	
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
