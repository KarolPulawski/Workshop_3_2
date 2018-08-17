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

@WebServlet(name = "PanelOrderController", urlPatterns = {"/panelOrder"})
public class PanelOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = null;
        try {
            orders = OrderDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelOrder.jsp").forward(request, response);
    }
}
