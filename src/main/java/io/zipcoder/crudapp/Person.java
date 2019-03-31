package io.zipcoder.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Person {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String firstName;
    public String lastName;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

}
