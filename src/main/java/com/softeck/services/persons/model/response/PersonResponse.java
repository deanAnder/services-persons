package com.softeck.services.persons.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonResponse implements Serializable {

    private static final long serialVersionUID = -5745717529692749692L;

    private long idPersona;

    private String name;

    private String dni;

    private String employer;

    private String Status;
}
