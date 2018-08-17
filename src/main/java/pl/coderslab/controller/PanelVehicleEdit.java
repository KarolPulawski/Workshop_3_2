package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelVehicleEdit", urlPatterns = {"/panelVehicleEdit"})
public class PanelVehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("vehicleId"));
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setModel(request.getParameter("vehicleModel"));
        vehicle.setBrand(request.getParameter("vehicleBrand"));
        vehicle.setProductionYear(request.getParameter("vehicleProductionYear"));
        vehicle.setRegistrationNumber(request.getParameter("vehicleRegistrationNumber"));
        vehicle.setTechnicalReviewDate(DateService.dateFromString(request.getParameter("vehicleTechnicalReviewDate")));
        try {
            vehicle.setCustomer(CustomerDao.loadById(Integer.parseInt(request.getParameter("vehicleCustomerId"))));
            VehicleDao.save(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelVehicle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("vehicleId"));
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelVehicleEdit.jsp").forward(request, response);

    }
}
