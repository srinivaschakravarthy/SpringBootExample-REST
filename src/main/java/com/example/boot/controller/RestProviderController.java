package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot.model.Person;
import com.example.boot.model.PersonList;
import com.example.boot.service.PersonService;

/**
 * REST service provider
 * 
 * Only GET and POST will return values PUT and DELETE will not.
 */
@Controller
public class RestProviderController {
	@Autowired
	PersonService personService;

	/*
	 * Rest method to retrieve List from service class and add it in the data
	 * list created in PersonList class
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody PersonList getPerson()  {
			
	PersonList result = new PersonList();
		// Sets the List returned by getAll() method in PersonList
		result.setData(personService.getAll());
		return result;
	}

	/*
	 * Rest service method to get Person object based on Id
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, headers = "Accept=text/plain,application/xml, application/json")
	public @ResponseBody Person getPerson(@PathVariable("id") Long id) {
		// Call service here
		return personService.get(id);
	}


	/*
	 * Rest method to add Person object in the service class PersonList
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody Person addPerson(@RequestBody Person person) {
		// Call service to here
		return personService.add(person);
	}



/*@RequestMapping(value = "/person/{id}", 
    							method = RequestMethod.PUT, headers="Accept=application/xml, application/json")
public @ResponseBody String updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
    	//logger.debug("Provider has received request to edit person with id: " + id);
    	
    	// Call service here
    	person.setId(id);
    	return personService.edit(person).toString();
    }
    


    
    @RequestMapping(value = "/person/{id}", 
    							method = RequestMethod.DELETE,
    							headers="Accept=application/xml, application/json")
	public @ResponseBody String deleteEmployee(@PathVariable("id") Long id) {
    	logger.debug("Provider has received request to delete person with id: " + id);
 
    	// Call service here
    	return personService.delete(id).toString();
    }

*/









}
