package com.javi.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javi.aopdemo.dao.AccountDAO;
import com.javi.aopdemo.dao.MembershipDAO;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
					
					
		// close the context
		context.close();
		
	}

}
