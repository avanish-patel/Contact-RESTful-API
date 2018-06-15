/*
*  Created by
*  @Author Avanish Patel
*/

package com.solstice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.solstice.model.Contact;
import com.solstice.service.ContactService;

import io.swagger.annotations.ApiOperation;

/**
 * @author avanish
 * 
 *         This is the controller class that maps request for each different URI
 *
 */
@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * This API is used for getting the stored contacts from the database.
	 * 
	 * @return list of Contact
	 */
	@ApiOperation(value = "Get all contacts")
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getContacts() {

		return contactService.getContacts();
	}

	/**
	 * This API is used for creating new contact for database.
	 * 
	 * @return void
	 */
	@ApiOperation(value = "Add a new contact")
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public void createTopic(@RequestBody Contact contact) {

		contactService.createContact(contact);
	}

	/**
	 * This API is used for getting the stored contacts from the database by name.
	 * 
	 * @return specific Contact
	 */
	@ApiOperation(value = "Get contact by name")
	@RequestMapping(value = "/contacts/{name}", method = RequestMethod.GET)
	public Contact getContact(@PathVariable String name) {

		return contactService.getContact(name);
	}

	/**
	 * This API is used for updating the contact stored in database by name.
	 * 
	 * @return void
	 */
	@ApiOperation(value = "Update a contact by name")
	@RequestMapping(value = "/contacts/{name}", method = RequestMethod.PUT)
	public void updateTopic(@PathVariable String name, @RequestBody Contact contact) {

		contactService.updateContact(name, contact);
	}

	/**
	 * This API is used for deleting the stored contacts from the database by name.
	 * 
	 * @return void
	 */
	@ApiOperation(value = "Delete a contact by name")
	@RequestMapping(value = "/contacts/{name}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String name) {

		contactService.deleteContact(name);
	}

	/**
	 * This API is used for searching the stored contacts from the database by
	 * email.
	 * 
	 * @return of Contact
	 */
	@ApiOperation(value = "Search a contact by email id")
	@RequestMapping(value = "/contacts/email/{email}", method = RequestMethod.GET)
	public Contact getByEmail(@PathVariable String email) {

		return contactService.getByEmail(email);
	}

	/**
	 * This API is used for searching the stored contacts from the database by
	 * email.
	 * 
	 * @return list of Contact
	 */
	@ApiOperation(value = "Search a contact by personal phone number")
	@RequestMapping(value = "/contacts/phone/{phoneNumber}", method = RequestMethod.GET)
	public Contact getByPhone(@PathVariable String phoneNumber) {

		return contactService.getByPhone(phoneNumber);
	}

	/**
	 * This API is used for retrieving the stored contacts from the database by same
	 * city.
	 * 
	 * @return list of Contact
	 */
	@ApiOperation(value = "Retrieve the conacts from same city")
	@RequestMapping(value = "/contacts/city/{city}", method = RequestMethod.GET)
	public List<Contact> getContactsByCity(@PathVariable String city) {

		return contactService.getContactsByCity(city);
	}

	/**
	 * This API is used for retrieving the stored contacts from the database by same
	 * state.
	 * 
	 * @return list of Contact
	 */
	@ApiOperation(value = "Retrive the contact form same state")
	@RequestMapping(value = "/contacts/state/{state}", method = RequestMethod.GET)
	public List<Contact> getContactsByState(@PathVariable String state) {

		return contactService.getContactByState(state);
	}

}
