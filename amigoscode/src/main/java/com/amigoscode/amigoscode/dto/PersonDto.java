package com.amigoscode.amigoscode.dto;

import com.amigoscode.amigoscode.model.Person;

import java.util.UUID;

public interface PersonDto {
    int insertPerson(UUID id, Person peron);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
