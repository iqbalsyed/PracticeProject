package com.pp.E_learning_Webapp;
import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertNotNull; 
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test; 



public class CourseTest {
	CourseService cou; 
 	@BeforeMethod 
 	public void setup() { 
 	 	cou=new CourseService(); 
 	 	 
 	} 
 	@AfterMethod 
 	public void cleanup() { 
 	 	if(cou!=null) 
 	 	 	cou=null; 
 	} 
 	 
 	@Test(description="test checking course is not null") 
 	public void test2() { 
 	 	assertNotNull(cou); 
 	} 
 	@Test(description="test checking the course list")  
 	public void test3() { 
 	 	int expectedResult=5; 
 	 	int actualResult=cou.getCourses().size();
 	 	assertEquals(expectedResult,actualResult); 
} 

}
