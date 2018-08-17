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

@WebServlet(name = "PanelCustomerEdit", urlPatterns = {"/panelCustomerEdit"})
public class PanelCustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = new Customer();
        customer.setId(id);
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
        request.setAttribute("id", request.getParameter("customerId"));
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelCustomerEdit.jsp").forward(request, response);
    }
}
