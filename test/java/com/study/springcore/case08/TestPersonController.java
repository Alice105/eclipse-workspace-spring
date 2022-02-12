package com.study.springcore.case08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonController {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonContoller personContoller = ctx.getBean("personContoller", PersonContoller.class);
		
		//personContoller.printAllPersons();
		//personContoller.addPerson("Bob", 2013, 12, 26);
		//personContoller.printAllPersons();
				
		System.out.println(personContoller.getPersonByName("Randy"));
		System.out.println(personContoller.getPersonByName("Tom"));
	}

}