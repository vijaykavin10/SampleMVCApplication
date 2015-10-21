package net.viralpatel.contact.dao;

import java.util.List;

import net.viralpatel.contact.form.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
    
	public Contact getContact(Integer id) {
			String sql = "FROM Contact WHERE id='"+ id +"'";
			List<Contact> result = sessionFactory.getCurrentSession().createQuery(sql).list();
            return (result.size() > 0) ? null : result.get(0);
	}
}
