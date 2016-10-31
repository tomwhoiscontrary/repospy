package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Potato {

    @Id
    @GeneratedValue
    private Integer id;

    private String kind;

    public Potato(String kind) {
        this.kind = kind;
    }

    protected Potato() {
    }

    public String getKind() {
        return kind;
    }

}
