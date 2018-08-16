package pl.coderslab.model;

public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String number;
    private String note;
    private Double salaryPerHour;

    public Employee() {
    }

    public Employee(String name, String surname, String address, String number, String note, Double salaryPerHour) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.note = note;
        this.salaryPerHour = salaryPerHour;
    }

    public Employee(Integer id, String name, String surname, String address, String number, String note, Double salaryPerHour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.note = note;
        this.salaryPerHour = salaryPerHour;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}


