package com.softeck.services.persons.business;

import com.softeck.services.persons.model.request.PersonRequest;
import com.softeck.services.persons.model.response.PersonResponse;
import io.reactivex.Single;

public interface PersonService {

    Single<PersonResponse> createPerson(PersonRequest request);

    Single<PersonResponse> deletePerson(Integer personId);

}
