package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelEmployeeAdd", urlPatterns = {"/panelEmployeeAdd"})
public class PanelEmployeeAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
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

    }
}
