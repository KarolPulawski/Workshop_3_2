package pl.coderslab.service;

public class Finance {
    private Double priceClients;
    private Double priceParts;
    private Double priceEmployee;
    private Integer workingHour;

    public Finance(Double priceClients, Double priceParts, Double priceEmployee, Integer workingHour) {
        this.priceClients = priceClients;
        this.priceParts = priceParts;
        this.priceEmployee = priceEmployee;
        this.workingHour = workingHour;
    }

    public Finance() {
    }

    public Double getPriceClients() {
        return priceClients;
    }

    public void setPriceClients(Double priceClients) {
        this.priceClients = priceClients;
    }

    public Double getPriceParts() {
        return priceParts;
    }

    public void setPriceParts(Double priceParts) {
        this.priceParts = priceParts;
    }

    public Double getPriceEmployee() {
        return priceEmployee;
    }

    public void setPriceEmployee(Double priceEmployee) {
        this.priceEmployee = priceEmployee;
    }

    public Integer getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(Integer workingHour) {
        this.workingHour = workingHour;
    }
}
