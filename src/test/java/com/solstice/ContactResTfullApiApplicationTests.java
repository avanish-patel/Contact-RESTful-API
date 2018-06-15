package com.solstice;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.solstice.controller.ContactController;
import com.solstice.model.Address;
import com.solstice.model.Contact;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class)
public class ContactResTfullApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ContactController controller;

	@Test
	public void contextLoads() {
		assertNotNull("controller shouldn't be null.", controller);
	}

	@Test
	public void testGetContacts() {
		Address address = new Address();
		address.setCity("Chicago");
		address.setState("IL");
		address.setStreet("S Pulaski");
		address.setZipcode("12345");
		Contact contact = new Contact("TestUser1", "Solatice", null, "testuser1@gmail.com", "01011990", "123456789",
				"987654321", address);
		String expectedJSON = "[{\"name\":\"TestUser1\",\"company\":\"Solatice\",\"profilePic\":null,\"email\":\"testuser1@gmail.com\",\"birthday\":\"01011990\",\"phoneWork\":\"123456789\",\"phonePersonal\":\"987654321\",\"address\":{\"street\":\"S Pulaski\",\"city\":\"Chicago\",\"state\":\"IL\",\"zipcode\":\"12345\"}}]";
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(contact);

		Mockito.when(controller.getContacts()).thenReturn(contactList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts").accept(MediaType.APPLICATION_JSON);
		try {

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());

			org.junit.Assert.assertEquals("Contactlist doesn't match.", expectedJSON,
					result.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}