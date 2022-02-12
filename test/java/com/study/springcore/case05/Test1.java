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

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john =ctx.getBean("s1",Student.class);
		System.out.println(john);
		
		Student mary =ctx.getBean("s2",Student.class);
		System.out.println(mary);
		/*
		//請問mary的老師有誰? 印出name
		System.out.println(mary.getName()+"的課程:"+mary.getClazzs());
		Teacher[] teachers= {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		Set<Teacher> teachers2=new LinkedHashSet<>();
		for(Teacher teacher:teachers) {
			clazz_loop:
			for(Clazz cla1:teacher.getClazzs()) {
				for(Clazz cla2:mary.getClazzs()) {
					if(cla1.getId()==cla2.getId()) {
						//System.out.println(teacher.getName());
						teachers2.add(teacher);
						break clazz_loop;//顯示老師不重複
					}
				}
			}
		}
		System.out.println(mary.getName()+"的老師:"+ teachers2);
		System.out.println(mary.getName()+"的老師:"+ teachers2.stream()
													.map(Teacher::getName)
													.collect(Collectors.toSet()));
		*/
		
		/*
		//請問mary的老師有誰? 印出name
		System.out.println(mary.getName()+"的課程:"+mary.getClazzs());
		Teacher[] teachers= {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		//add By TS Start
		//List<Clazz> mary_class = new ArrayList<Clazz>();
		List<Integer> mary_class = new ArrayList<Integer>();//empty list to save mary class id
		List<Student> mary_1 = Arrays.asList(mary);
		for (Student student : mary_1) {
			System.out.println(student.getClazzs());
				for(Clazz cla1:student.getClazzs()) {
					//System.out.print(cla1.getId()+" ");
					//System.out.println(cla1.getName());
					mary_class.add(cla1.getId());
				}

		}
		System.out.println("Mary Class "+mary_class);
		//System.out.println(mary_1.stream(Filter<T>));
		//add by TS Finish
		//Set<Teacher> teachers2=new LinkedHashSet<>();
		//add by TS start
		//to get the teacher's information
		List<Teacher> teacher3 = Arrays.asList(teachers); //add by TS
			//System.out.println(teacher3.size()); //add by TS
			for (Teacher teacher : teacher3) {
				//System.out.println(teacher.toString());
				//System.out.println(teacher.getName());
				for(Clazz cla2:teacher.getClazzs()) {
					//System.out.print(cla2.getId()+ " ");
					//System.out.println(cla2.getName());
						for(Integer m_class:mary_class) {
							if (cla2.getId() == m_class) {
								System.out.println("Mary's Teacher: "+teacher.getName());
							}
						}
				}
			}
			*/
		
		//請問mary的老師有誰? 印出name
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