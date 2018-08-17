package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelVehicleController", urlPatterns = {"/panelVehicle"})
public class PanelVehicleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("vehicleId"));
        Vehicle vehicle = null;
        try {
            vehicle = VehicleDao.loadById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("vehicle", vehicle);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelDetailVehicles.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = null;
        try {
            vehicles = VehicleDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("vehicles", vehicles);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelVehicle.jsp").forward(request, response);

    }
}
