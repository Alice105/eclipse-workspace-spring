package com.study.springcore.case06;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
		
		Car car1 = ctx.getBean("car",Car.class);						
		System.out.println(car1);
		
		Car car2 = ctx.getBean("car",Car.class);						
		System.out.println(car2);
	}
}