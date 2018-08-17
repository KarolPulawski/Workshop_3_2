package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.service.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelOrderEdit", urlPatterns = {"/panelOrderEdit"})
public class PanelOrderEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("orderId"));
            Order order = new Order();
            order.setId(id);
            order.setReceiveDate(DateService.dateFromString(request.getParameter("orderReceiveDate")));
            order.setStartDate(DateService.dateFromString(request.getParameter("orderStartDate")));
            order.setEmployee(EmployeeDao.loadById(Integer.parseInt(request.getParameter("orderEmployeeId"))));
            order.setDescriptionProblem(request.getParameter("orderDescriptionProblem"));
            order.setDescriptionRepair(request.getParameter("orderDescriptionRepair"));
            order.setStatus(Status.valueOf(request.getParameter("orderStatus")));
            order.setVehicle(VehicleDao.loadById(Integer.parseInt(request.getParameter("orderVehicleId"))));
            order.setPriceClient(Double.parseDouble(request.getParameter("orderPriceClient")));
            order.setPriceParts(Double.parseDouble(request.getParameter("orderPriceParts")));
            order.setPriceEmployee(Double.parseDouble(request.getParameter("orderPriceEmployee")));
            order.setNumberHour(Integer.parseInt(request.getParameter("orderNumberHour")));
            OrderDao.save(order);
            response.sendRedirect("/panelOrder");
        } catch (Exception e) {
            response.getWriter().println("VEHICLE ID DOES NOT EXIST");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("orderId"));
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelOrderEdit.jsp").forward(request, response);

    }
}
