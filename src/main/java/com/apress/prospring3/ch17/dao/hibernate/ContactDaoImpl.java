package com.apress.prospring3.ch17.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch17.dao.ContactDao;
import com.apress.prospring3.ch17.domain.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {

	private Log log = LogFactory.getLog(ContactDaoImpl.class);
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	@Override
	public List<Contact> findAllWithDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
