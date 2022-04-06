package com.softeck.services.persons.model;

import lombok.Getter;

@Getter
public enum Status {

    ENABLE(1),
    DISABLE(0);

    private final int value;

    Status(int value) {
        this.value = value;
    }
}