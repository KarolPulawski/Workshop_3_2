package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelOrderEditStatus", urlPatterns = {"/panelOrderEditStatus"})
public class PanelOrderEditStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("orderId"));
        Status status = Status.valueOf(request.getParameter("status"));
        try {
            Order order = OrderDao.loadById(id);
            order.setStatus(status);
            OrderDao.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/panelOrder");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("orderId"));
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelOrderEditStatus.jsp").forward(request, response);
    }
}
