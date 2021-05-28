package com.demo.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterEncoding implements Filter {
     public static  String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            HttpServletRequest rt=(HttpServletRequest)request;
            HttpServletResponse re=(HttpServletResponse)response;
            rt.setCharacterEncoding(encoding);
            re.setContentType("text/html;charset=" + encoding);
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {
        encoding=null;
    }
}
