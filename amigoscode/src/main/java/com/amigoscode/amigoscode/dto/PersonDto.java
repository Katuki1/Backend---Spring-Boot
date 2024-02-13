package com.amigoscode.amigoscode.dto;

import com.amigoscode.amigoscode.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDto {
    int insertPerson(UUID id, Person peron);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person>selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
