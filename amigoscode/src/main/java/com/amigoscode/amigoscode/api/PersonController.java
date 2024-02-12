package com.amigoscode.amigoscode.api;

import com.amigoscode.amigoscode.model.Person;
import com.amigoscode.amigoscode.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
