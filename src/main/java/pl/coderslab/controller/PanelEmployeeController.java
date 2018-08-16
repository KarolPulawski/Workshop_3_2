package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelEmployeeController", urlPatterns = {"/panelEmployee"})
public class PanelEmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("employeeId"));
        List<Order> orders = null;
        try {
            orders = OrderDao.loadByEmployeeId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelEmployeeOrders.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = null;
        try {
            employees = EmployeeDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("employees", employees);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelEmployee.jsp").forward(request, response);
    }
}
