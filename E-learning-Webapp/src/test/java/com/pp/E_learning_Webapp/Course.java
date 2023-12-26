package com.pp.E_learning_Webapp;

public class Course {
	public int CourseId; public String CourseName;
	public String CourseContent;
	public String getCourseContent() { 
	 	return CourseContent; 
	} 
	public void setCourseContent(String courseContent) { 
	 	CourseContent = courseContent; 
	} 
	public int getCourseId() { 
	 	return CourseId; 
	} 
	public Course(int courseId, String courseName, String courseContent) { 
	 	super(); 
	 	CourseId = courseId; 
	 	CourseName = courseName; 
	 	CourseContent = courseContent; 
	} 
	public void setCourseId(int courseId) { 
	 	CourseId = courseId; 
	} 
	public String getCourseName() { 
	return CourseName; 
	} 
	public void setCourseName(String courseName) { 
	 	CourseName = courseName; 
	} 
	 
} 



