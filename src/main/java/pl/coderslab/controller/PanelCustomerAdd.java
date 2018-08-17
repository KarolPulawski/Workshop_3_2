package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;
import pl.coderslab.service.DateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelCustomerAdd", urlPatterns = {"/panelCustomerAdd"})
public class PanelCustomerAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("customerName"));
        customer.setSurname(request.getParameter("customerSurname"));
        customer.setBirthday(DateService.dateFromString(request.getParameter("customerBirthday")));
        try {
            CustomerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelCustomer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
