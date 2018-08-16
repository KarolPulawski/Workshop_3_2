package pl.coderslab.dao;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DateService;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDao {

    public static void delete(Vehicle vehicle) throws Exception {
        String query = "DELETE FROM vehicle WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(vehicle.getId()));
        DbService.executeQuery(query, params);
        vehicle.setId(0);
    }

    public static void save(Vehicle vehicle) throws Exception {
        if (vehicle.getId() == null) {
            String query = "INSERT INTO vehicle VALUES(null,?,?,?,?,?,?)";
            List<String> params = new ArrayList<>();
            params.add(vehicle.getModel());
            params.add(vehicle.getBrand());
            params.add(vehicle.getProductionYear());
            params.add(vehicle.getRegistrationNumber());
            params.add(String.valueOf(vehicle.getTechnicalReviewDate()));
            params.add(String.valueOf(vehicle.getCustomer().getId()));
            Integer id = DbService.insertIntoDatabase(query, params);
            vehicle.setId(id);
        } else {
            String query = "UPDATE vehicle SET model = ?, brand = ?, " +
                    "productionYear = ?, registrationNumber = ?, " +
                    "technicalReviewDate = ?, customer_id = ? " +
                    "WHERE id = ? ";
            List<String> params = new ArrayList<>();
            params.add(vehicle.getModel());
            params.add(vehicle.getBrand());
            params.add(vehicle.getProductionYear());
            params.add(vehicle.getRegistrationNumber());
            params.add(String.valueOf(vehicle.getTechnicalReviewDate()));
            params.add(String.valueOf(vehicle.getCustomer().getId()));
            params.add(String.valueOf(vehicle.getId()));
            DbService.executeQuery(query, params);
        }
    }
    public static Vehicle loadById(Integer id) throws Exception {
        String query = "SELECT * FROM vehicle WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        Vehicle vehicle = null;
        List<Map<String,String>> data = DbService.getData(query, params);
        for(Map<String,String> row : data) {
            vehicle = createNewVehicle(row);
        }
        return vehicle;
    }

    public static List<Vehicle> loadAll() throws Exception {
        String query = "SELECT * FROM vehicle";
        List<Vehicle> vehicles = new ArrayList<>();
        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String,String> row : data) {
            vehicles.add(createNewVehicle(row));
        }
        return vehicles;
    }

    private static Vehicle createNewVehicle(Map<String, String> row) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(Integer.parseInt(row.get("id")));
        vehicle.setBrand(row.get("brand"));
        vehicle.setModel(row.get("model"));
        vehicle.setProductionYear(row.get("productionYear"));
        vehicle.setRegistrationNumber(row.get("registrationNumber"));
        vehicle.setTechnicalReviewDate(DateService.dateFromDbString(row.get("technicalReviewDate")));
        vehicle.setCustomer(CustomerDao.loadById(Integer.parseInt(row.get("customer_id"))));
        return vehicle;
    }
}
