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

@WebServlet(name = "SearchControllerOrders", urlPatterns = {"/searchControllerOrders"})
public class SearchControllerOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("vehicleId"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByVehicleId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelSpecificOrdersSearch.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
