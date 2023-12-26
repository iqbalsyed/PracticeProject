package com.pp.E_learning_Webapp;

import org.testng.annotations.Test; 

import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertNotNull; 
import static org.testng.Assert.assertTrue; 
 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class TrainingTest {
	TrainingService training; 
	   @BeforeTest 
	 	public void setup() {  	 	
		   training=new TrainingService(); 
	 	} 
	 	@AfterTest 
	 	public void cleanUP() { 
	 	 	if(training!=null) 
	 	 	 	training=null; 
	 	} 
	 	@Test 
	 	public void test1() {  	 
	 		assertNotNull(training); 
	 	} 
	 	@Test 
	 	public void test2() {  	 
	 		assertTrue(training.getTrainings().size()==5); 
	 	} 
	 	@Test 
	 	public void test3() {  	 
	 		assertEquals(training.getTrainings().size(),5); 
	 	} 


}
