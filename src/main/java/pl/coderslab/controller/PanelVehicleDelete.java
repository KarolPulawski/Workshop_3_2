package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelVehicleDelete", urlPatterns = {"/panelVehicleDelete"})
public class PanelVehicleDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("vehicleId"));
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(id);
            VehicleDao.delete(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelVehicle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
