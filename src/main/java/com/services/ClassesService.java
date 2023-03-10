package com.services;

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


}
