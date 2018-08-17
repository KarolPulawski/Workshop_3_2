package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelEmployeeStatus", urlPatterns = {"/panelEmployeeStatus"})
public class PanelEmployeeStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status status = Status.valueOf(request.getParameter("status"));
        List<Employee> employees = null;
        try {
            employees = EmployeeDao.loadByStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("employees", employees);
        request.setAttribute("status", status);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelSpecificEmployeesStatus.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelEmployeeEditStatus.jsp").forward(request, response);
    }
}
