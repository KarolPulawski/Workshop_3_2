package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.service.DateService;
import pl.coderslab.service.DbService;
import pl.coderslab.service.ReportService;
import pl.coderslab.service.Worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ControllerReport1", urlPatterns = {"/report1"})
public class ControllerReport1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Timestamp dateFrom = DateService.dateFromString(request.getParameter("dateFrom"));
        Timestamp dateTo = DateService.dateFromString(request.getParameter("dateTo"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByDateRange(dateFrom, dateTo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Worker> finalList = ReportService.employeeWorkingHours(orders);

        request.setAttribute("finalList", finalList);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelSpecificOrdersReport1.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/META-INF/views/report1Select.jsp").forward(request, response);
    }
}
