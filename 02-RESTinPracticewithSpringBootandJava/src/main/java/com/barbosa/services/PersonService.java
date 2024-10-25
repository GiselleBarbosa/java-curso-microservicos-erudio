package com.barbosa.services;

import com.barbosa.exceptions.ResourceNotFoundException;
import com.barbosa.model.Person;
import com.barbosa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person create(Person person) {
        logger.info("Creating one person!");

        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No records found with id: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);

    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No records found with id: " + id));

        personRepository.delete(entity);
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No records found with id: " + id));

    }

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return personRepository.findAll();
    }
}