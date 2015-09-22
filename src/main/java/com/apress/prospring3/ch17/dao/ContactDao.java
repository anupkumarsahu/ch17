package com.apress.prospring3.ch17.dao;

import java.util.List;

import com.apress.prospring3.ch17.domain.Contact;

public interface ContactDao {

	public List<Contact> findAll();
	
	public List<Contact> findAllWithDetails();
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);
	
	public void delete(Contact contact);
}
