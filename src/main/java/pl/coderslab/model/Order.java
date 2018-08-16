package pl.coderslab.model;

import java.sql.Timestamp;

public class Order {
    private Integer id;
    private Timestamp receiveDate;
    private Timestamp startDate;
    private Employee employee;
    private String descriptionProblem;
    private String descriptionRepair;
    private Status status;
    private Vehicle vehicle;
    private double priceClient;
    private double priceParts;
    private double priceEmployee;
    private int numberHour;

    public Order() {
    }

    public Order(Integer id, Timestamp receiveDate, Timestamp startDate, Employee employee, String descriptionProblem, String descriptionRepair, Status status, Vehicle vehicle, double priceClient, double priceParts, double priceEmployee, int numberHour) {
        this.id = id;
        this.receiveDate = receiveDate;
        this.startDate = startDate;
        this.employee = employee;
        this.descriptionProblem = descriptionProblem;
        this.descriptionRepair = descriptionRepair;
        this.status = status;
        this.vehicle = vehicle;
        this.priceClient = priceClient;
        this.priceParts = priceParts;
        this.priceEmployee = priceEmployee;
        this.numberHour = numberHour;
    }

    public Order(Timestamp receiveDate, Timestamp startDate, Employee employee, String descriptionProblem, String descriptionRepair, Status status, Vehicle vehicle, double priceClient, double priceParts, double priceEmployee, int numberHour) {
        this.receiveDate = receiveDate;
        this.startDate = startDate;
        this.employee = employee;
        this.descriptionProblem = descriptionProblem;
        this.descriptionRepair = descriptionRepair;
        this.status = status;
        this.vehicle = vehicle;
        this.priceClient = priceClient;
        this.priceParts = priceParts;
        this.priceEmployee = priceEmployee;
        this.numberHour = numberHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescriptionProblem() {
        return descriptionProblem;
    }

    public void setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
    }

    public String getDescriptionRepair() {
        return descriptionRepair;
    }

    public void setDescriptionRepair(String descriptionRepair) {
        this.descriptionRepair = descriptionRepair;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getPriceClient() {
        return priceClient;
    }

    public void setPriceClient(double priceClient) {
        this.priceClient = priceClient;
    }

    public double getPriceParts() {
        return priceParts;
    }

    public void setPriceParts(double priceParts) {
        this.priceParts = priceParts;
    }

    public double getPriceEmployee() {
        return priceEmployee;
    }

    public void setPriceEmployee(double priceEmployee) {
        this.priceEmployee = priceEmployee;
    }

    public int getNumberHour() {
        return numberHour;
    }

    public void setNumberHour(int numberHour) {
        this.numberHour = numberHour;
    }
}
