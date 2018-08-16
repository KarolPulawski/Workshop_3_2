package pl.coderslab.model;

import java.sql.Timestamp;

public class Customer {
    private Integer id;
    private String name;
    private String surname;
    private Timestamp birthday;

    public Customer() {
    }

    public Customer(String name, String surname, Timestamp birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Customer(Integer id, String name, String surname, Timestamp birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}


