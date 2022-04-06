package com.softeck.services.persons.business.impl;

import com.softeck.services.persons.business.PersonService;
import com.softeck.services.persons.entity.Persons;
import com.softeck.services.persons.model.Status;
import com.softeck.services.persons.model.request.PersonRequest;
import com.softeck.services.persons.model.response.PersonResponse;
import com.softeck.services.persons.repository.PersonRepository;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Single<PersonResponse> deletePerson(Integer personId) {
        return Single.fromCallable(() -> personId)
                .map(id -> {
                    Persons persons = new Persons();
                    persons.setId(id.longValue());
                    persons.setStatus(Status.DISABLE.getValue());
                    return personRepository.save(persons);
                })
                .map(this::mapperResponse);
    }

    public Single<PersonResponse> createPerson(PersonRequest request) {

        return Single.just(request)
                .map(requestPerson -> {
                    Persons persons = new Persons();
                    if (requestPerson.getIdPerson() != null) {
                        persons.setId(requestPerson.getIdPerson().longValue());
                    }
                    persons.setDni(requestPerson.getDni());
                    persons.setName(requestPerson.getName());
                    persons.setEmployer(requestPerson.getEmployer());
                    persons.setStatus(Status.ENABLE.getValue());
                    return personRepository.save(persons);
                })
                .map(this::mapperResponse);
    }

    private PersonResponse mapperResponse(Persons persons) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setDni(persons.getDni());
        personResponse.setEmployer(persons.getEmployer() != 0 ? "SI" : "NO");
        personResponse.setName(persons.getName());
        personResponse.setIdPersona(persons.getId());
        if (persons.getStatus() == 0) {
            personResponse.setStatus("DISABLE");
        }
        return personResponse;
    }

}
