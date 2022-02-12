package com.study.springcore.case05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john =ctx.getBean("s1",Student.class);
		System.out.println(john);
		
		Student mary =ctx.getBean("s2",Student.class);
		System.out.println(mary);
		
		//請問mary的老師有誰? 印出name
		//王菀柔
		System.out.println(mary.getName()+"的課程:"+mary.getClazzs());
		Teacher[] teachers= {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		List<Integer> mary_class = new ArrayList<Integer>();
		List<Student> mary_1 = Arrays.asList(mary);
		for (Student student : mary_1) {
			for(Clazz cla1:student.getClazzs()) {
				mary_class.add(cla1.getId());
			}
		}
		List<Teacher> teacher3 = Arrays.asList(teachers);
			for (Teacher teacher : teacher3) {
				for(Clazz cla2:teacher.getClazzs()) {
					for(Integer m_class:mary_class) {
						if (cla2.getId() == m_class) {
										
						}
					}
				}
			}
		System.out.println(mary.getName()+"的老師:"+ teacher3.stream()
											.map(Teacher::getName)
											.collect(Collectors.toSet()));
	}
}