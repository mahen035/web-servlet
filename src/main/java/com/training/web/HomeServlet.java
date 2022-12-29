package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	String msg;
	
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	msg = "Hello from Servlet!";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletConfig().getServletContext();
		
		String value = context.getInitParameter("value1");
		
		String usrName = request.getParameter("uname");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h4> "+usrName+" "+value+" </h4>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post method is called...");
		doGet(request, response);
	}

}

// Create an html as your welcome page with some text and a link
// when the link is clicked it will invoke a servlet that displays list of topics
// covered so far in this training

// Servlet Config : Initial parameters can be configured using ServletConfig
// Each Servlet will have their own Servlet Config


// Your company name should come from the servlet context
// create at least two servlets wherein one servlet will have a config with username
// and password. Username and password field will be there in html page
// when user wants to login, the credentials will be compared with the one present in
// the config. On successful login, Welcome <username> should be displayed.
