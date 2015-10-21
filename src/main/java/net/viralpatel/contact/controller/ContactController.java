package net.viralpatel.contact.controller;

import java.util.Map;

import net.viralpatel.contact.form.Contact;
import net.viralpatel.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}
    
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping(value = "/get/{contactId}", method = RequestMethod.GET)
	public String getContact(@PathVariable("contactId") Integer contactId) {
		contactService.getContact(contactId);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/update/{contactId}", method = RequestMethod.PUT)
	public String updateContact(@PathVariable("contactId") Contact newContact, Integer contactId, BindingResult result) {
		contactService.updateContact(newContact,contactId);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/delete/{contactId}", method = RequestMethod.DELETE)
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
