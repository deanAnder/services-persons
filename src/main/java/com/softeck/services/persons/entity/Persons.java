package com.softeck.services.persons.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Persons implements Serializable {

    private static final long serialVersionUID = 8745945385030828904L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dni")
    private String dni;

    @Column(name = "employer")
    private int employer;

    @Column(name = "status")
    private int status;

}
