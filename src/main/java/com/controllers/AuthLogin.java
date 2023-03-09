package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthLogin
 */
@WebServlet("/AuthLogin")
public class AuthLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin123";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		if(uname.equals(USERNAME)&&pwd.equals(PASSWORD)) {
			//out.println("Welcome "+uname);
			response.sendRedirect("dashboard.jsp");
		}
		else {
			out.println("Wrong username/password");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

}
