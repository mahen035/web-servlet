package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.web.model.User;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String)request.getAttribute("user");
		String password = (String)request.getAttribute("pwd");
		List<User> usrList = (List<User>)request.getAttribute("userList");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("userList", usrList);
		
		Cookie cookie1 = new Cookie("username", user);
		//Cookie cookie2 = new Cookie("password", password);
		
		response.addCookie(cookie1);
		//response.addCookie(cookie2);
		
		request.setAttribute("user", user);
		
		request.setAttribute("usrList", usrList);
		
		RequestDispatcher rd = request.getRequestDispatcher("usrDetail.jsp");
		rd.forward(request, response);
		
		
		/*
		 * out.print("<h1>Welcome "+user+"! You are successfully logged in </h1>");
		 * 
		 * out.println("<table border='1'> "); out.println("<tr> <th>");
		 * out.println("Name </th>"); out.println("<th> Password </th>"); for(User
		 * usr:usrList) { out.println("<tr><td>" +usr.getUserName() +"</td>");
		 * out.println("<td>" +usr.getPassword() +"</td> </tr>"); }
		 */
		
		/* COOKIES
		 * out.print("<h3> Cookies are created. Click on the below "+
		 * " button to get the cookie </h3>" );
		 * out.print("<form action = 'GetCookieServlet' method = 'POST'>");
		 * out.print("<input type = 'submit' value = 'Get Cookie'>");
		 * out.print("</form>");
		 */
		
		//Hidden Fields
		/*
		 * out.println("<h3> Click on the below "+
		 * " button to see the values of username and password </h3>" );
		 * out.println("<form action = 'GetHiddenFieldsServlet' method = 'POST'");
		 * out.println("<input type= 'hidden' name = 'user1' value = '"+user+"'>");
		 * out.println("<input type= 'hidden' name = 'pwd' value = "+password+">");
		 * out.println("<input type= 'submit' value = 'See values'/>");
		 * out.println("</form");
		 */
		
		// URL ReWriting
		//out.println("<h3> Click on the below link to see username and password</h3><br/>");
		//out.println("<a href='GetUrlParamServlet?userName="+user+"&password="+password+"'>Click here</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//Servlet Filter: Used to do pre-processing of request or post-processing of the response.

// HTTP is a stateless protocol: It doesn't keep track of the client who sends the request

// 1. Cookie  2. Hidden form fields  3. Url rewriting 4. HttpSession

// Cookie: small piece of information stored in client's machine by a web application

//JSP: Java Server Pages-> html that can contain java code


