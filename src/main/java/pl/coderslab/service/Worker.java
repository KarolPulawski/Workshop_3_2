package pl.coderslab.service;

public class Worker {
    private Integer id;
    private String name;
    private String surname;
    private Integer workingHour;

    public Worker() {
    }

    public Worker(Integer id, String name, String surname, Integer workingHour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingHour = workingHour;
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

    public Integer getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(Integer workingHour) {
        this.workingHour = workingHour;
    }
}
