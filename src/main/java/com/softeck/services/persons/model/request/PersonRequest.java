package com.softeck.services.persons.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private Integer idPerson;

    private String name;

    private String dni;

    private int employer;

}
