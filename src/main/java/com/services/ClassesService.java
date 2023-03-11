package com.services;

import java.util.List;

import com.daos.ClassesDao;
import com.entities.Classes;

public class ClassesService {

		ClassesDao cd=new ClassesDao();
		
		public String registerClass(Classes classes) {
			System.out.println("In service class");
			if(cd.registerClass(classes)>0) {
				return "Class data stored successfully";
			}else {
				return "Class details didn't store";
			}
		}
		
		public List<Classes> viewClass() {
			return cd.viewClass();
		}

}
