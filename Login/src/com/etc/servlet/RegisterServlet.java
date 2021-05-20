package com.etc.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.service.CustomerService;
import com.etc.pojo.Customer;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * <p>
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custname = request.getParameter("custname");
		String pwd = request.getParameter("pwd");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		Customer cust = new Customer(custname, pwd, age, address);
		CustomerService cs = new CustomerService();

		boolean flag = false;
		flag = cs.register(cust);
		if (flag) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}


	}

	/**
	 * The doPost method of the servlet. <br>
	 * <p>
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custname = request.getParameter("custname");
		String pwd = request.getParameter("pwd");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		Customer cust = new Customer(custname, pwd, age, address);
		CustomerService cs = new CustomerService();

		boolean flag = false;

		flag = cs.register(cust);

		if (flag) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
