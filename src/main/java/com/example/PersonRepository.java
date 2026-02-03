package com.example;

import io.ebean.Database;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    private Database db;

    public List<Person> findAll() {
        return db.find(Person.class)
                .findList();
    }
}