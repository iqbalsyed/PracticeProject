package com.simplilearn.phase2.Phase2_selenium_tetsng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgStandardAnnotaion {
	@BeforeSuite
	public void setupbeforetestsuit() {
		System.out.println("----Before test suit----");
		
	}
	@AfterSuite
	public void setupaftertestsuite() {
		System.out.println("----After test suite----");
		
	}
	@BeforeClass
	public void setupbeforeClass() {
		System.out.println("----Before Class----");
		
	}
	@AfterClass
	public void setupafterClass() {
		System.out.println("----After Class----");
		
	}
	@BeforeMethod
	public void setupbeforeTest() {
		System.out.println("----Before Test is executed----");
		
	}
	@AfterMethod
	public void setupAfterTest() {
		System.out.println("----After Test is executed----");
		
	}
	@Test
	public void testOne(){
		System.out.println("----Test One is executed----");
	}
	@Test
	public void testTwo() {
		System.out.println("----Test Two is executed----");
	}
	@Test
	@Ignore
	public void testThree() {
		System.out.println("----Test Three is executed----");
	}
	

}
