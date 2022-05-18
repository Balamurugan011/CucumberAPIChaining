package org.runner;

import org.base.CucumberReports;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Addcarts.feature",glue="org.stepdefinition",dryRun=false,monochrome=true,plugin= {"pretty","json:C:\\\\Users\\\\ELCOT\\\\eclipse-workspace\\\\CucumberApiChaining\\\\target\\\\Reports.json"})
public class TestRunner {
//	
//	@AfterClass
//	public static void afterScenerio() {
//CucumberReports.generateReports("C:\\Users\\ELCOT\\eclipse-workspace\\CucumberApiChaining\\target\\Reports.json");
//	}
//	
//	
	
}
