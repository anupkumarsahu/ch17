package com.apress.prospring3.ch17.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch17.domain.Contact;
import com.apress.prospring3.ch17.repository.ContactRepository;
import com.apress.prospring3.ch17.service.ContractService;
import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContractService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
}
