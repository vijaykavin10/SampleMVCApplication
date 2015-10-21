package net.viralpatel.contact.service;

import java.util.List;
import org.hibernate.SessionFactory;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.viralpatel.contact.dao.ContactDAO;
import net.viralpatel.contact.form.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Autowired  
	 private SessionFactory sessionFactory;
	
	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}

	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}

	@Transactional
	public Contact getContact(Integer id) {
		Contact contact = contactDAO.getContact(id);		
       return null;
	}

	public Contact updateContact(Contact newContact, Integer id) {
        Contact contact = contactDAO.getContact(id);
        if(newContact.getFirstname() != null){
        	contact.setFirstname(newContact.getFirstname());
       }
        if(newContact.getLastname() != null){
        	contact.setLastname(newContact.getLastname());
       }
        if(newContact.getEmail() != null){
        	contact.setEmail(newContact.getEmail());
       }
        if(newContact.getTelephone() != null){
        	contact.setTelephone(newContact.getTelephone());
       }
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
		return null;
	}
}
