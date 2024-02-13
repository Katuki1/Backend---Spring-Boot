package com.amigoscode.amigoscode.dto;

import com.amigoscode.amigoscode.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakePerson")
public class FakePersonService implements PersonDto{

    private static List <Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return personDB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personDB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
       Optional <Person> personMaybe = selectPersonById(id);
       if(personMaybe.isEmpty()){
           return 0;
       }
       personDB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToUpdate = personDB.indexOf(person1);
                    if(indexOfPersonToUpdate >= 0){
                        personDB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
