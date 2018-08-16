package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.service.DateService;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDao {

    public static void delete(Customer customer) throws Exception{
        String query = "DELETE FROM customer WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(customer.getId()));
        DbService.executeQuery(query, params);
        customer.setId(0);
    }

    public static void save(Customer customer) throws Exception {
        if(customer.getId() == null) {
            add(customer);
        } else {
            update(customer);
            return;
        }
    }

    private static void add(Customer customer) throws Exception {
        String query = "INSERT INTO customer VALUES (null, ?,?,?)";
        List<String> params = new ArrayList<>();
        params.add(customer.getName());
        params.add(customer.getSurname());
        params.add(String.valueOf(customer.getBirthday()));

        Integer id = DbService.insertIntoDatabase(query, params);
        customer.setId(id);
    }

    private static void update(Customer customer) throws Exception {
        String query = "UPDATE customer SET name = ?, surname = ?, birthday = ? " +
                "WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(customer.getName());
        params.add(customer.getSurname());
        params.add(String.valueOf(customer.getBirthday()));
        params.add(String.valueOf(customer.getId()));
        DbService.executeQuery(query,params);
    }

    public static Customer loadById(Integer id) throws Exception {
        String query = "SELECT * FROM customer WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        Customer customer = null;
        List<Map<String, String>> data = DbService.getData(query, params);
        for(Map<String, String> row : data) {
            customer = createNewCustomer(row);
        }
        return customer;
    }

    public static List<Customer> loadAll() throws Exception {
        String query = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();
        List<Map<String,String>> data = DbService.getData(query, null);
        for(Map<String, String> row : data) {
            customers.add(createNewCustomer(row));
        }
        return customers;
    }

    private static Customer createNewCustomer(Map<String, String> row) {
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(row.get("id")));
        customer.setName(row.get("name"));
        customer.setSurname(row.get("surname"));
        customer.setBirthday(DateService.dateFromDbString(row.get("birthday")));
        return customer;
    }
}
