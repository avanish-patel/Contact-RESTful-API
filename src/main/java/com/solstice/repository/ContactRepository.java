/*
*  Created by
*  @Author Avanish Patel
*/

package com.solstice.repository;

import org.springframework.data.repository.CrudRepository;

import com.solstice.model.Contact;


/**
 * @author avanish 
 * The interface that extends CrudRepostory and provides methods
 *         available to persist the object
 */
public interface ContactRepository extends CrudRepository<Contact, String>{
	

}
