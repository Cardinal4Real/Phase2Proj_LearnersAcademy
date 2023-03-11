package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.ClassesDao;
import com.entities.Classes;

/**
 * Servlet implementation class ClassesController
 */
@WebServlet(name="ClassesController",value="/dashboard")
public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassesDao classDao=new ClassesDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.setContentType("text/html"); ClassesService cs=new ClassesService();
		 * List<Classes> classList=cs.viewClass(); request.setAttribute("listOfClasses",
		 * classList); RequestDispatcher
		 * rdVC=request.getRequestDispatcher("viewClasses.jsp"); rdVC.include(request,
		 * response);
		 */
		response.setContentType("text/html");
		String nav=request.getParameter("navigate");
		PrintWriter out=response.getWriter();
		if(!nav.isBlank()) {
		switch(nav) {
		case "classes":
			//List<Classes> classList=classDao.viewClass();
			request.setAttribute("listOfClasses", classDao.viewClass());
			break;
		case "students":
			break;
		case "subjects":
			break;
		case "teachers":
			break;
		default:
			break;
		}

		request.getRequestDispatcher("dashboard.jsp?navigate="+nav).forward(request, response);
		}else {
			out.println("Link cannot be null");
			request.getRequestDispatcher("index.jsp").include(request, response);	
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * ClassesService cs=new ClassesService(); Classes classes=new Classes();
		 * classes.setCname(request.getParameter("cname")); cs.registerClass(classes);
		 * doGet(request, response);
		 */
		response.setContentType("text/html");
		String nav=request.getParameter("navigate");
		PrintWriter out=response.getWriter();
		out.println("Page is "+nav);
		
		switch(nav) {
		case "classes":
			if(request.getParameter("cname").isBlank()) {
				out.println("Class name cannot be empty");
			}else {
			Classes classes=new Classes();
			classes.setCname(request.getParameter("cname"));
			classDao.registerClass(classes);}
			break;
		case "students":
			break;
		case "subjects":
			break;
		case "teachers":
			break;
		default:
			break;
		}
		doGet(request,response);

	}

}
