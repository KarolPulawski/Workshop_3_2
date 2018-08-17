package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelCustomerDelete", urlPatterns = {"/panelCustomerDelete"})
public class PanelCustomerDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("customerId"));
        try {
            Customer customer = new Customer();
            customer.setId(id);
            CustomerDao.delete(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelCustomer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
