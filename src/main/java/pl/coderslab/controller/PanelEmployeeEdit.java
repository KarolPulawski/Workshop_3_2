package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelEmployeeEdit", urlPatterns = {"/panelEmployeeEdit"})
public class PanelEmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(request.getParameter("employeeName"));
        employee.setSurname(request.getParameter("employeeSurname"));
        employee.setAddress(request.getParameter("employeeAddress"));
        employee.setNumber(request.getParameter("employeeNumber"));
        employee.setNote(request.getParameter("employeeNote"));
        employee.setSalaryPerHour(Double.parseDouble(request.getParameter("employeeSalary")));
        try {
            EmployeeDao.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelEmployee");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("employeeId"));
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelEmployeeEdit.jsp").forward(request, response);
    }
}
