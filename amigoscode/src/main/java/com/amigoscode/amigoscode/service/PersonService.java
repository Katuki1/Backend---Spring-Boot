package com.amigoscode.amigoscode.service;

import com.amigoscode.amigoscode.dto.PersonDto;
import com.amigoscode.amigoscode.model.Person;

public class PersonService {
    private final PersonDto personDto;

    public PersonService(PersonDto personDto) {
        this.personDto = personDto;
    }

    public int addPerson(Person person){
        return personDto.insertPerson(person);
    }
}
