package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.web.model.User;

/**
 * Servlet implementation class GetUrlParamServlet
 */
@WebServlet("/GetUrlParamServlet")
public class GetUrlParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUrlParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		
		String pass = request.getParameter("password");
		
		//Http Session object
		HttpSession session = request.getSession(false);
		
		List<User> userList = (List<User>)session.getAttribute("userList");
		
		out.println("Username: "+userName +"<br/><br/>");
		out.println("Password: "+pass+"<br/><br/>" );
		
		out.println("<table border='1'> ");
		out.println("<tr> <th>");
		out.println("Name </th>");
		out.println("<th> Password </th>");
		for(User usr:userList) {
			out.println("<tr><td>" +usr.getUserName() +"</td>");
			out.println("<td>" +usr.getPassword() +"</td> </tr>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
