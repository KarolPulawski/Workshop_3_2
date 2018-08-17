package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PanelCustomerController", urlPatterns = {"/panelCustomer"})
public class PanelCustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        try {
            customers = CustomerDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("customers", customers);
        request.getServletContext().getRequestDispatcher("/META-INF/views/panelCustomer.jsp").forward(request, response);
    }
}
