package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read Spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring context
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		//claa theaccountDAO getter/setter methods
		theAccountDAO.setName("Teste");
		theAccountDAO.setServiceCode("T1000");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();

	}

}
