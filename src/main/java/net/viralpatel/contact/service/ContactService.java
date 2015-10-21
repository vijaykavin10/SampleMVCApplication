package net.viralpatel.contact.service;

import java.util.List;

import net.viralpatel.contact.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public Contact getContact(Integer id);
	public Contact updateContact(Contact newContact,Integer id);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
