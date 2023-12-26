package com.pp.E_learning_Webapp;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

	List<Course> course; 
 	public CourseService() {  	 	course=new ArrayList<>();  	 	course.add(new Course(1,"Selenium",null));  	 	course.add(new Course(2,"JUnit",null));  	 	course.add(new Course(3,"TestNG",null));  	 	course.add(new Course(4,"Selinium Grid",null)); 
 	 	course.add(new Course(5,"POM Framework",null)); 
 	 	 
 	} 
 	public List<Course> getCourses(){ 
 	 	 
 	 	return course; 
 	} 

}
