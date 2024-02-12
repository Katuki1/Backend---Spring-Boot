package com.amigoscode.amigoscode.dto;

import com.amigoscode.amigoscode.model.Person;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePerson implements PersonDto{

    private static List <Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDB.add(new Person(id, person.getName()));
        return 1;
    }
}
