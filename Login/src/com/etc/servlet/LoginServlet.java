package com.etc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.service.CustomerService;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String custname = request.getParameter("custname");
        String pwd = request.getParameter("pwd");
        CustomerService cs = new CustomerService();
        boolean flag = false;
            flag = cs.login(custname, pwd);
        if (flag) {
            HttpSession session = request.getSession();
            session.setAttribute("custname", custname);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

}
