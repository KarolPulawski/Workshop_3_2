package pl.coderslab.model;

import java.sql.Timestamp;

public class Vehicle {
    private Integer id;
    private String model;
    private String brand;
    private String productionYear;
    private String registrationNumber;
    private Timestamp technicalReviewDate;
    private Customer customer;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String productionYear, String registrationNumber, Timestamp technicalReviewDate, Customer customer) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.technicalReviewDate = technicalReviewDate;
        this.customer = customer;
    }

    public Vehicle(Integer id, String model, String brand, String productionYear, String registrationNumber, Timestamp technicalReviewDate, Customer customer) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.technicalReviewDate = technicalReviewDate;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Timestamp getTechnicalReviewDate() {
        return technicalReviewDate;
    }

    public void setTechnicalReviewDate(Timestamp technicalReviewDate) {
        this.technicalReviewDate = technicalReviewDate;
    }
}


