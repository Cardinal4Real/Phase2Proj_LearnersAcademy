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
import com.daos.StudentsDao;
import com.daos.SubjectsDao;
import com.daos.TeachersDao;
import com.entities.Classes;
import com.entities.Students;
import com.entities.Subjects;
import com.entities.Teachers;

/**
 * Servlet implementation class ClassesController
 */
@WebServlet(name="ClassesController",value="/dashboard")
public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassesDao classDao=new ClassesDao();
    StudentsDao studentDao=new StudentsDao();
    SubjectsDao subjectDao=new SubjectsDao();
    TeachersDao teacherDao=new TeachersDao();
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
		case "subjects":
			request.setAttribute("listOfSubjects", subjectDao.viewSubjects());
			request.setAttribute("listOfClasses", classDao.viewClass());
			break;
		case "students":
			request.setAttribute("listOfStudents", studentDao.viewStudents());
			request.setAttribute("listOfClasses", classDao.viewClass());
			break;
		case "teachers":
			request.setAttribute("listOfTeachers", teacherDao.viewTeachers());
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
			if(request.getParameter("sname").isBlank()) {
				out.println("Student name cannot be empty");
			}else {
			Students students=new Students();
			students.setSname(request.getParameter("sname"));
			studentDao.registerStudent(students);}
			break;
		case "subjects":
			if(request.getParameter("subname").isBlank()) {
				out.println("Subject name cannot be empty");
			}else {
			Subjects subjects=new Subjects();
			subjects.setSubname(request.getParameter("subname"));
			subjectDao.registerSubject(subjects);}
			break;
		case "teachers":			
			if(request.getParameter("tname").isBlank()) {
				out.println("Subject name cannot be empty");
			}else {
			Teachers teachers=new Teachers();
			teachers.setTname(request.getParameter("tname"));
			teacherDao.registerTeacher(teachers);}
			break;
		default:
			break;
		}
		doGet(request,response);

	}

}
