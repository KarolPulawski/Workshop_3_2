package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeDisplayDetails", urlPatterns = {"/displayDetails"})
public class HomeDisplayDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("orderId"));
        Order order = null;

        try {
            order = OrderDao.loadById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("order", order);
        request.getServletContext().getRequestDispatcher("/META-INF/views/indexDetails.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
