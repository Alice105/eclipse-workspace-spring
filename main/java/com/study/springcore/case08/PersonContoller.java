package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 功能:
 * 1.建立Person資料
 * 		->輸入name,birth
 * 2.取得Person全部資料
 * 		->不用輸入參數
 * 3.根據姓名取得Person的生日
 * 		->輸入name
 * 4.根據某日期取得今天生日的Person
 * 		->輸入今天日期
 * 5.取得某一歲數以上的Person
 * 		->輸入age
 * 6.根據姓名修改Person的生日
 * 		->輸入name,birth
 * 7.根據姓名取得來刪除Person
 * 		->輸入name
 * */

@Controller
public class PersonContoller {
	
	@Autowired
	private PersonService personService;
	
	public void addPerson(String name, int yyyy, int mm, int dd) {
		// 1. 判斷 name, yyyy, mm 與 dd 是否有資料?
		// 2. 將 yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPerson(String name, Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 2. 建立 Person 資料
		boolean check = personService.append(name, birth);
		System.out.println("add person: " + check);
	}
	
	public void printAllPersons() {
		//System.out.println(personService.findAllPersons());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 資料呈現
		List<Person> people = personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	
	// 根據姓名取得 Person
	public Person getPersonByName(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		Person person = personService.getPerson(name);
		return person;
	}
}
