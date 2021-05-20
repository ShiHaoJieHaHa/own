package com.etc.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.service.CustomerService;
import com.etc.pojo.Customer;

public class GetAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//调用业务逻辑
        CustomerService cs = new CustomerService();
        List<Customer> list = cs.viewAll();//
		// 将返回值作为请求属性存储
        request.setAttribute("allcustomers", list);
//		跳转
        request.getRequestDispatcher("allcustomers.jsp").forward(request, response);
    }
}
