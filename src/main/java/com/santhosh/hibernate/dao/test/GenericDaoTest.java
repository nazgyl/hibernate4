package com.santhosh.hibernate.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.santhosh.hibernate.Customer;
import com.santhosh.hibernate.dao.GenericDao;

public class GenericDaoTest {
	public static void main(String[] args) {
		ApplicationContext context=new FileSystemXmlApplicationContext(
				"src/main/resources/beans.xml");
		GenericDao dao=(GenericDao)context.getBean("customerDAO");
		Customer customer=new Customer(1);
		dao.create(customer);
		
	}

}
