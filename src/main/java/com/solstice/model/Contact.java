/*
*  Created by
*  @Author Avanish Patel
*/

package com.solstice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author avanish
 *Contact class that represents the Contact data-type
 */
@Entity
public class Contact {

	@Id
	@NotNull
	private String name;
	private String company;
	private byte[] profilePic;
	@Email
	private String email;
	private String birthday;
	private String phoneWork;
	private String phonePersonal;
	@Autowired
	Address address;

	public Contact() {

	}

	public Contact(String name, String company, byte[] profilePic, String email, String birthday, String phoneWork,
			String phonePersonal, Address address) {
		super();
		this.name = name;
		this.company = company;
		this.profilePic = profilePic;
		this.email = email;
		this.birthday = birthday;
		this.phoneWork = phoneWork;
		this.phonePersonal = phonePersonal;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public byte[] getprofilePic() {
		return profilePic;
	}

	public void setprofilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public String getPhonePersonal() {
		return phonePersonal;
	}

	public void setPhonePersonal(String phonePersonal) {
		this.phonePersonal = phonePersonal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
