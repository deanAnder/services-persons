package com.softeck.services.persons.repository;

import com.softeck.services.persons.entity.Persons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Persons, Long> {

}
