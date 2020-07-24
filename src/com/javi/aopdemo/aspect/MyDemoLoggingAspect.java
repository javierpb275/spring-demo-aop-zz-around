package com.javi.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.javi.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(*com.javi.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint)  throws Throwable {
		 	
			return null;
			
		}
	
	
	/*
	// After advice:
	
	@After("execution(*com.javi.aopdemo.dao.AccountDAO.findAccounts(..))")//@After will run for success or failure (finally)
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @After (finally) advice on method: " + method);
		
	}
	
	// AfterThrowing advice:
	@AfterThrowing(
			pointcut="execution(*com.javi.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")//parameter name for exception
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @AfterThrowing advice on method: " + method);
		
		// log the exception
		System.out.println("\n=====>>>> The exception is: " + theExc);
		
	}
	
	// AfterReturning advice:
	
	@AfterReturning(
			pointcut="execution(*com.javi.aopdemo.dao.AccountDAO.findAccounts(..))", //match on AccountDAO.findAccounts(..)
			returning="result")//parameter name for return value
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Executing @AfterReturning advice on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>>> result is: " + result);
		
		// let's post-process the data ... let's modify it:
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		// print out the result
		System.out.println("\n=====>>>> result is: " + result);
	}
	*/
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		
		for (Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
		
	}


	@Before("com.javi.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")//added fully qualified class name
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)  theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
				
			}
			
		}
		
		
	}
	

}
