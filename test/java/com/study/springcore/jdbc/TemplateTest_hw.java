package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;
import com.study.springcore.jdbc.template.EmpJobDao;
import com.study.springcore.jdbc.template.hw_InvoiceDao;

public class TemplateTest_hw {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		hw_InvoiceDao hw_invoiceDao = ctx.getBean("hw_invoiceDao", hw_InvoiceDao.class);
		
		hw_invoiceDao.queryhw_Invoices().forEach(System.out::println);
		System.out.println();
		
	}

}