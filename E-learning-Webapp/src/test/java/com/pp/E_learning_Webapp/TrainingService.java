package com.pp.E_learning_Webapp;

import java.util.ArrayList;
import java.util.List;

public class TrainingService {
	List<Training> training;  	public TrainingService() {  	 
		training=new ArrayList<>();  	
		training.add(new Training(1,"Selenium"));  	 
		training.add(new Training(2,"TestNG"));  	
		training.add(new Training(3,"JUnit"));  	
		training.add(new Training(4,"Selenium-Grid"));  	
		training.add(new Training(5,"POM Framework")); 
 	} 
 
 	public List<Training> getTrainings() { 
 	 	return training; 
 	} 

}
