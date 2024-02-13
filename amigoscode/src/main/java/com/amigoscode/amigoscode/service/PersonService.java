package com.amigoscode.amigoscode.service;

import com.amigoscode.amigoscode.dto.PersonDto;
import com.amigoscode.amigoscode.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDto personDto;

    @Autowired
    public PersonService(@Qualifier("fakePerson") PersonDto personDto) {
        this.personDto = personDto;
    }

    public int addPerson(Person person){
        return personDto.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDto.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDto.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDto.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDto.updatePersonById(id, newPerson);
    }
}
