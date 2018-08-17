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

@WebServlet(name = "SearchController", urlPatterns = {"/searchController"})
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Customer> customers = null;
        try {
            customers = CustomerDao.loadBySurname(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        customers.forEach(s -> { System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getSurname());
            System.out.println(s.getBirthday());});
        request.setAttribute("customers", customers);
//        request.getServletContext().getRequestDispatcher("/home").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
