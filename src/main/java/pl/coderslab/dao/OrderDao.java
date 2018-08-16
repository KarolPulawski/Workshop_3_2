package pl.coderslab.dao;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.service.DateService;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

    public static void delete(Order order) throws Exception {
        String query = "DELETE FROM orders WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(order.getId()));
        DbService.executeQuery(query, params);
        order.setId(0);
    }

    public static void save(Order order) throws Exception {
        if(order.getId() == null) {
            add(order);
        } else {
            update(order);
            return;
        }
    }

    private static void add(Order order) throws Exception {
        String query = "INSERT INTO orders VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(order.getReceiveDate()));
        params.add(String.valueOf(order.getStartDate()));
        params.add(String.valueOf(order.getEmployee().getId()));
        params.add(order.getDescriptionProblem());
        params.add(order.getDescriptionRepair());
        params.add((order.getStatus().toString()));
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getPriceClient()));
        params.add(String.valueOf(order.getPriceParts()));
        params.add(String.valueOf(order.getPriceEmployee()));
        params.add(String.valueOf(order.getNumberHour()));
        Integer id = DbService.insertIntoDatabase(query, params);
        order.setId(id);
    }

    private static void update(Order order) throws Exception {
        String query = "UPDATE orders SET receiveDate = ?, startDate = ?, employee_id = ?, " +
                "descriptionProblem = ?, descriptionRepair = ?, status = ?, vehicle_id = ?, " +
                "priceClient = ?, priceParts = ?, priceEmployee = ?, numberHour = ? " +
                "WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(order.getReceiveDate()));
        params.add(String.valueOf(order.getStartDate()));
        params.add(String.valueOf(order.getEmployee().getId()));
        params.add(order.getDescriptionProblem());
        params.add(order.getDescriptionRepair());
        params.add(String.valueOf(order.getStatus()));
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getPriceClient()));
        params.add(String.valueOf(order.getPriceParts()));
        params.add(String.valueOf(order.getPriceEmployee()));
        params.add(String.valueOf(order.getNumberHour()));
        params.add(String.valueOf(order.getId()));
        DbService.executeQuery(query, params);
    }

    public static Order loadById(Integer id) throws Exception {
        String query = "SELECT * FROM orders WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        Order order = new Order();
        List<Map<String, String>> data = DbService.getData(query, params);
        for(Map<String, String> row : data) {
            order = createOrder(row);
        }
        return order;
    }

    public static List<Order> loadAll() throws Exception {
        String query = "SELECT * FROM orders";
        List<Map<String, String>> data = DbService.getData(query, null);
        List<Order> orders = new ArrayList<>();
        for(Map<String, String> row : data) {
            orders.add(createOrder(row));
        }
        return orders;
    }

    private static Order createOrder(Map<String, String> row) throws Exception {
        Order order = new Order();
        order.setId(Integer.parseInt(row.get("id")));
        order.setReceiveDate(DateService.dateFromDbString(row.get("receiveDate")));
        order.setStartDate(DateService.dateFromDbString(row.get("startDate")));
        order.setEmployee(EmployeeDao.loadById(Integer.parseInt(row.get("employee_id"))));
        order.setDescriptionProblem(row.get("descriptionProblem"));
        order.setDescriptionRepair(row.get("descriptionRepair"));
        order.setStatus(Status.valueOf(row.get("status")));
        order.setVehicle(VehicleDao.loadById(Integer.parseInt(row.get("vehicle_id"))));
        order.setPriceClient(Double.parseDouble(row.get("priceClient")));
        order.setPriceParts(Double.parseDouble(row.get("priceParts")));
        order.setPriceEmployee(Double.parseDouble(row.get("priceEmployee")));
        order.setNumberHour(Integer.parseInt(row.get("numberHour")));
        return order;
    }

}