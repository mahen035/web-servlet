package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.training.web.service.LoginService;
import com.training.web.service.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/welcomeServlet")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		LoginService service = new LoginServiceImpl();
				
		if(userName.equals("") || password.equals("")) {
			out.print("<h2>**Please enter username and password**<h2>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		 
		else if(service.isValidUser(userName, password)) {
			request.setAttribute("user", userName);
			chain.doFilter(request, response);
		}
	
		else {
			out.print("<h2>Incorrect login credential!!<h2>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
