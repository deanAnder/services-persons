package com.softeck.services.expose;

import com.softeck.services.persons.business.PersonService;
import com.softeck.services.persons.model.request.PersonRequest;
import com.softeck.services.persons.model.response.PersonResponse;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExposeWeb {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/register-person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Single<PersonResponse>> registerPerson(
            @RequestBody PersonRequest request) {
        return ResponseEntity
                .ok(personService.createPerson(request));
    }


    @PutMapping(value = "/update-person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Single<PersonResponse>> updatePerson(
            @RequestBody PersonRequest request) {
        return ResponseEntity
                .ok(personService.createPerson(request));
    }

    @DeleteMapping(value = "/delete-person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Single<PersonResponse>> deletePerson(
            @RequestBody PersonRequest request) {
        return ResponseEntity
                .ok(personService.deletePerson(request.getIdPerson()));
    }

}
