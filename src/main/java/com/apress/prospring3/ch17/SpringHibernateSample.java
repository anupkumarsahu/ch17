package com.apress.prospring3.ch17;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch17.dao.ContactDao;
import com.apress.prospring3.ch17.domain.Contact;

public class SpringHibernateSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:app-context.xml");
		context.refresh();
		
		ContactDao contactDao = context.getBean("contactDao",ContactDao.class);
		List<Contact> contacts = contactDao.findAll();
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact: contacts) {
		System.out.println(contact);
		System.out.println();
		}
		}
	
}
