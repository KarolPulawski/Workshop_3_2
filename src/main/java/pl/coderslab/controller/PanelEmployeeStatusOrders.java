package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelEmployeeStatusOrders", urlPatterns = {"/panelEmployeeStatusOrders"})
public class PanelEmployeeStatusOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status status = Status.valueOf(request.getParameter("status"));
        Integer id = Integer.parseInt(request.getParameter("employeeId"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByCustomerIdStatus(id, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelSpecificOrders.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
