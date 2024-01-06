package com.simplilearn.bddtest.phase2_phaseEnd_Project.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
	glue = {"com/simplilearn/bddtest/phase2_phaseEnd_Project/stepdefinition"})
public class TestRunner {

}
