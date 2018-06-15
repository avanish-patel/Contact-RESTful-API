/*
*  Created by
*  @Author Avanish Patel
*/

package com.solstice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solstice.model.Contact;
import com.solstice.repository.ContactRepository;

/**
 * @author avanish
 *Class that provide service to contact controller
 */
@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	/**
	 * This Method is used for getting the stored contacts from the database.
	 * 
	 * @return list of Contact
	 */
	public List<Contact> getContacts() {

		List<Contact> contacts = new ArrayList<>();

		contactRepository.findAll().forEach(contacts::add);

		return contacts;

	}

	/**
	 * This Method is used for creating new contacts and storing it.
	 * 
	 * @return void
	 */
	public void createContact(Contact contact) {

		contactRepository.save(contact);
	}

	/**
	 * This Method is used for searching the stored contacts from the database by name.
	 * 
	 * @return specific Contact
	 */
	public Contact getContact(String name) {

		return contactRepository.findById(name).get();

	}

	/**
	 * This Method is used for updating the stored contacts from the database.
	 * 
	 * @return list of Contact
	 */
	public void updateContact(String name, Contact contact) {

		contactRepository.save(contact);
	}

	/**
	 * This Method is used for deleting the stored contacts from the database by name.
	 * 
	 * @return void
	 */
	public void deleteContact(String name) {

		contactRepository.deleteById(name);
	}
	
	/**
	 * This Method is used for searching the stored contacts from the database by email.
	 * @return specific Contact
	 */
	public Contact getByEmail(String email) {

		List<Contact> contacts = new ArrayList<>();

		contactRepository.findAll().forEach(contacts::add);

		return contacts.stream().filter(t -> t.getEmail().equals(email)).findFirst().get();
	}

	/**
	 * This Method is used for searching the stored contacts from the database by personal phone number.
	 * @return specific Contact
	 */
	public Contact getByPhone(String phoneNumber) {

		List<Contact> contacts = new ArrayList<>();

		contactRepository.findAll().forEach(contacts::add);

		return contacts.stream().filter(t -> t.getPhonePersonal().equals(phoneNumber)).findFirst().get();
	}
	
	/**
	 * This Method is used for retrieving the stored contacts from the database by same city.
	 * @return list of Contact
	 */
	public List<Contact> getContactsByCity(String city) {

		List<Contact> contacts = new ArrayList<>();

		contactRepository.findAll().forEach(contacts::add);

		return contacts.stream().filter(t -> t.getAddress().getCity().equals(city))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * This Method is used for retrieving the stored contacts from the database by same state.
	 * @return list of Contact
	 */
	public List<Contact> getContactByState(String state) {

		List<Contact> contacts = new ArrayList<>();

		contactRepository.findAll().forEach(contacts::add);

		return contacts.stream().filter(x -> x.getAddress().getState().equals(state))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
