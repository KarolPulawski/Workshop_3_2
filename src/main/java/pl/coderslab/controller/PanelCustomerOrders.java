package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelCustomerOrders", urlPatterns = {"/panelCustomerOrders"})
public class PanelCustomerOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("customerId"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByCustomerId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelSpecificOrders.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
