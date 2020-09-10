package ru.mutagarov.eduard.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDataService  {
    @Autowired
    PersonCrudRepository personCrudRepository;

    public void save(Person person) {
        personCrudRepository.save(person);
    }

    public List<Person> listAll() {
        return (List<Person>) personCrudRepository.findAll();
    }

    public void delete(Long id) {
        personCrudRepository.deleteById(id);
    }

    public Person get(Long personId) {
        return personCrudRepository.findById(personId).get();
    }
}
