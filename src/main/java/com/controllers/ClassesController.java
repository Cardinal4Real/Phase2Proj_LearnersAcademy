package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

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
		System.out.println("In the doGet method");
		response.setContentType("text/html");
		String nav=request.getParameter("navigate");
		PrintWriter out=response.getWriter();
		if(!nav.isBlank()) {
		switch(nav) {
		case "classes":
			//List<Classes> classList=classDao.viewClass();
			request.setAttribute("listOfClasses", classDao.findAll());
			break; 
		case "subjects":
			request.setAttribute("listOfSubjects", subjectDao.findAll());
			request.setAttribute("listOfTeachers", teacherDao.findAll());
			break;
		case "students":
			request.setAttribute("listOfStudents", studentDao.findAll());
			request.setAttribute("listOfClasses", classDao.findAll());
			break;
		case "teachers":
			request.setAttribute("listOfTeachers", teacherDao.findAll());
			//request.setAttribute("listOfSubjects", subjectDao.viewSubjects());
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
		System.out.println("In the doPost method");
		response.setContentType("text/html");
		String nav=request.getParameter("navigate");
		PrintWriter out=response.getWriter();
		out.println("Page is "+nav);
		
		switch(nav) {
		case "classes":
			processClass(request,response);
			break;
		case "students":
			processStudent(request,response);
			break;
		case "subjects":
			processSubjects(request,response);			
			break;
			
		case "teachers":			
			processTeacher(request,response);
			break;
			
		default:
			break;
		}
		doGet(request,response);

	}

	private void processSubjects(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String action=Optional.ofNullable(request.getParameter("action")).orElse("");
		String editSubID=Optional.ofNullable(request.getParameter("editSubID")).orElse("");		
		String deleteSubID=Optional.ofNullable(request.getParameter("deleteSubID")).orElse("");
		String editTID=Optional.ofNullable(request.getParameter("editTID")).orElse("");
		//String deleteTID=Optional.ofNullable(request.getParameter("deleteTID")).orElse("");
		String newSubName=Optional.ofNullable(request.getParameter("subname")).orElse("");
		String newTName=Optional.ofNullable(request.getParameter("tname")).orElse("");
		System.out.println("deleteSubID: "+deleteSubID);
		System.out.println("editSubID: "+editSubID);
		System.out.println("editTID: "+editTID);
		System.out.println("action: "+action);
		switch(action){
		case "edit":
			System.out.println("In edit subject loop");
			Subjects editSubject=subjectDao.findOne(Long.parseLong(editSubID));
			request.setAttribute("editSubject", editSubject);			
			Teachers editTeacher=teacherDao.findOne(Long.parseLong(editTID));
			request.setAttribute("editTeacher", editTeacher);
			break;
		case "delete":
			System.out.println("In delete subject loop");
			Subjects deleteSubject=subjectDao.findOne(Long.parseLong(deleteSubID));
			request.setAttribute("deleteSubject", deleteSubject);
			break;
		case "viewReport":
			break;
		default:
			if(!editSubID.isBlank()) {
				System.out.println("In the edit subscriber final loop");
				Subjects subject2edit=subjectDao.findOne(Long.parseLong(editSubID));
				subject2edit.setSubname(newSubName);
				Teachers teacher2edit=teacherDao.findOne(Long.parseLong(editTID));
				teacher2edit.setTname(newTName);
				System.out.println(subject2edit.toString());
				System.out.println(teacher2edit.toString());
				int res=subjectDao.register(subject2edit);
				int res2=teacherDao.register(teacher2edit);
				System.out.printf("Edited subject record %s",res);	
				System.out.printf("Edited subject record %s",res2);	
			}
			else if(!deleteSubID.isBlank()) {
				System.out.println("In the delete subject final loop");
				subjectDao.deleteOne(Long.parseLong(deleteSubID));
				System.out.println("Deleted subject record");
				
			}else {
				Subjects subjects=new Subjects();
				subjects.setSubname(request.getParameter("subname"));
				Teachers teachers=teacherDao.findOne(Long.parseLong(request.getParameter("selectedTeacher")));
				System.out.println(teachers.toString());
				subjects.setTeachers(teachers);
				subjectDao.register(subjects);}
			}		
		}

	private void processTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String action=Optional.ofNullable(request.getParameter("action")).orElse("");
		String editID=Optional.ofNullable(request.getParameter("editID")).orElse("");
		String deleteID=Optional.ofNullable(request.getParameter("deleteID")).orElse("");
		String newName=Optional.ofNullable(request.getParameter("tname")).orElse("");
		System.out.println("deleteID: "+deleteID);
		System.out.println("editID: "+editID);
		System.out.println("action: "+action);
		switch(action){
		case "edit":
			System.out.println("In edit teacher loop");
			Teachers editTeacher=teacherDao.findOne(Long.parseLong(editID));
			request.setAttribute("editTeacher", editTeacher);
			break;
		case "delete":
			System.out.println("In delete teacher loop");
			Teachers deleteTeacher=teacherDao.findOne(Long.parseLong(deleteID));
			request.setAttribute("deleteTeacher", deleteTeacher);
			break;
		case "viewReport":
			break;
		default:
			if(!editID.isBlank()) {
				System.out.println("In the edit final loop");
				Teachers teacher2edit=teacherDao.findOne(Long.parseLong(editID));
				teacher2edit.setTname(newName);
				System.out.println(teacher2edit.toString());
				int res=teacherDao.register(teacher2edit);
				System.out.printf("Edited teacher record %s",res);								
			}
			else if(!deleteID.isBlank()) {
				System.out.println("In the delete final loop");
				teacherDao.deleteOne(Long.parseLong(deleteID));
				System.out.println("Deleted teacher record");
				
			}else {
				System.out.println("Saving new teacher record");
				Teachers teachers=new Teachers();
				teachers.setTname(request.getParameter("tname"));
				teacherDao.register(teachers);	
			}
				break;		
		}
	}
	private void processClass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String action=Optional.ofNullable(request.getParameter("action")).orElse("");
		String editID=Optional.ofNullable(request.getParameter("editID")).orElse("");
		String deleteID=Optional.ofNullable(request.getParameter("deleteID")).orElse("");
		String newName=Optional.ofNullable(request.getParameter("cname")).orElse("");
		System.out.println("deleteID: "+deleteID);
		System.out.println("editID: "+editID);
		System.out.println("action: "+action);
		switch(action){
		case "edit":
			System.out.println("In edit class loop");
			Classes editClass=classDao.findOne(Long.parseLong(editID));
			request.setAttribute("editClass", editClass);
			break;
		case "delete":
			System.out.println("In delete class loop");
			Classes deleteClass=classDao.findOne(Long.parseLong(deleteID));
			request.setAttribute("deleteClass", deleteClass);
			break;
		case "viewReport":
			break;
		default:
			if(!editID.isBlank()) {
				System.out.println("In the edit final loop");
				Classes class2edit=classDao.findOne(Long.parseLong(editID));
				class2edit.setCname(newName);
				System.out.println(class2edit.toString());
				int res=classDao.register(class2edit);
				System.out.printf("Edited class record %s",res);								
			}
			else if(!deleteID.isBlank()) {
				System.out.println("In the delete final loop");
				classDao.deleteOne(Long.parseLong(deleteID));
				System.out.println("Deleted class record");
				
			}else {
				System.out.println("Saving new clas record");
				Classes classes=new Classes();
				classes.setCname(request.getParameter("cname"));
				classDao.register(classes);	
			}
				break;		
		}
	}
	private void processStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String action=Optional.ofNullable(request.getParameter("action")).orElse("");
		String editStudID=Optional.ofNullable(request.getParameter("editStudID")).orElse("");		
		String deleteStudID=Optional.ofNullable(request.getParameter("deleteStudID")).orElse("");
		String editCID=Optional.ofNullable(request.getParameter("editCID")).orElse("");
		//String deleteTID=Optional.ofNullable(request.getParameter("deleteTID")).orElse("");
		String newStudName=Optional.ofNullable(request.getParameter("sname")).orElse("");
		String newCName=Optional.ofNullable(request.getParameter("cname")).orElse("");
		System.out.println("editStudID: "+editStudID);
		System.out.println("deleteStudID: "+deleteStudID);
		System.out.println("editCID: "+editCID);
		System.out.println("action: "+action);
		switch(action){
		case "edit":
			System.out.println("In edit student loop");
			Students editStudent=studentDao.findOne(Long.parseLong(editStudID));
			request.setAttribute("editStudent", editStudent);			
			Classes editClass=classDao.findOne(Long.parseLong(editCID));
			request.setAttribute("editClass", editClass);
			break;
		case "delete":
			System.out.println("In delete student loop");
			Students deleteStudent=studentDao.findOne(Long.parseLong(deleteStudID));
			request.setAttribute("deleteStudent", deleteStudent);
			break;
		case "viewReport":
			break;
		default:
			if(!editStudID.isBlank()) {
				System.out.println("In the edit student final loop");
				Students student2edit=studentDao.findOne(Long.parseLong(editStudID));
				student2edit.setSname(newStudName);
				Classes class2edit=classDao.findOne(Long.parseLong(editCID));
				class2edit.setCname(newCName);
				System.out.println(student2edit.toString());
				System.out.println(class2edit.toString());
				int res=studentDao.register(student2edit);
				int res2=classDao.register(class2edit);
				System.out.printf("Edited subject record %s",res);	
				System.out.printf("Edited subject record %s",res2);	
			}
			else if(!deleteStudID.isBlank()) {
				System.out.println("In the delete student final loop");
				studentDao.deleteOne(Long.parseLong(deleteStudID));
				System.out.println("Deleted subject record");
				
			}else {
				Students students=new Students();
				students.setSname(request.getParameter("sname"));
				Classes classes=classDao.findOne(Long.parseLong(request.getParameter("selectedClass")));
				System.out.println(classes.toString());
				students.setClasses(classes);
				studentDao.register(students);}
			}		
		}
	
}
