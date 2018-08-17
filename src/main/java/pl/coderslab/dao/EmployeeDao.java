package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Status;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDao {

    public static List<Employee> loadByStatus(Status status) throws Exception {
        String query = "SELECT DISTINCT employee.* FROM orders " +
                "INNER JOIN employee on orders.employee_id = employee.id " +
                "WHERE status = '"+status+"'";
        List<Map<String, String>> data = DbService.getData(query, null);
        List<Employee> employees = new ArrayList<>();
        for(Map<String, String> row : data) {
            employees.add(createNewEmployee(row));
        }
        return employees;
    }

    public static void delete(Employee employee) throws Exception {
        String query = "DELETE FROM employee WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employee.getId()));
        DbService.executeQuery(query, params);
        employee.setId(0);
    }

    public static void save(Employee employee) throws Exception {
        if(employee.getId() == null) {
            add(employee);
        } else {
            update(employee);
            return;
        }
    }

    private static void update(Employee employee) throws Exception {
        String query = "UPDATE employee SET name = ?, surname = ?, " +
                "address = ?, number = ?, note = ?, salaryPerHour = ? " +
                "WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(employee.getName());
        params.add(employee.getSurname());
        params.add(employee.getAddress());
        params.add(employee.getNumber());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getSalaryPerHour()));
        params.add(String.valueOf(employee.getId()));
        DbService.executeQuery(query, params);
    }

    private static void add(Employee employee) throws Exception {
        String query = "INSERT INTO employee VALUES(null,?,?,?,?,?,?)";
        List<String> params = new ArrayList<>();
        params.add(employee.getName());
        params.add(employee.getSurname());
        params.add(employee.getAddress());
        params.add(employee.getNumber());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getSalaryPerHour()));
        Integer id = DbService.insertIntoDatabase(query, params);
        employee.setId(id);
    }

    public static Employee loadById(Integer id) throws Exception{
        String query = "SELECT * FROM employee WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        Employee employee = null;
        List<Map<String,String>> data = DbService.getData(query, params);
        for(Map<String, String> row : data) {
            employee = createNewEmployee(row);
        }
        return employee;
    }

    public static List<Employee> loadAll() throws Exception {
        String query = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();
        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String,String> row : data) {
            employees.add(createNewEmployee(row));
        }
        return employees;
    }

    private static Employee createNewEmployee(Map<String, String> row) {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(row.get("id")));
        employee.setName(row.get("name"));
        employee.setSurname(row.get("surname"));
        employee.setAddress(row.get("address"));
        employee.setNote(row.get("note"));
        employee.setNumber(row.get("number"));
        employee.setSalaryPerHour(Double.parseDouble(row.get("salaryPerHour")));
        return employee;
    }
}
