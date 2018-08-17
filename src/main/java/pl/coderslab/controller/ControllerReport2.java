package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.service.DateService;
import pl.coderslab.service.Finance;
import pl.coderslab.service.ReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ControllerReport2", urlPatterns = {"/report2"})
public class ControllerReport2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Timestamp dateFrom = DateService.dateFromString(request.getParameter("dateFrom"));
        Timestamp dateTo = DateService.dateFromString(request.getParameter("dateTo"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByDateRangeStatus(dateFrom, dateTo, Status.COST_ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Finance> finances = ReportService.financePeriod(orders);
        request.setAttribute("finances", finances);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelReport2.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/META-INF/views/report1Select.jsp").forward(request, response);
    }
}
