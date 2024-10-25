package com.barbosa.services;

import com.barbosa.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Giselle");
        person.setLastName("Barbosa");
        person.setAddress("São Paulo - SP");
        person.setGender("Female");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some address " + i);
        person.setGender("Female");
        return person;
    }

}