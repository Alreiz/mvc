package ru.mutagarov.eduard.mvc.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonCrudRepository extends CrudRepository<Person, Long> {

}