package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.sample.JvmReport;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\karth\\eclipse-framework\\FramworkCucumber\\src\\test\\resources\\Feature\\",
plugin= {"pretty","json:C:\\Users\\karth\\eclipse-framework\\FramworkCucumber\\Report\\cucumber.json"},
                          glue={"org.sample"},dryRun=false,monochrome = true,snippets= SnippetType.CAMELCASE,tags= {"@reg"})

public class TestRunneer {
	
	
	@AfterClass
	public static void afterClass() {
	JvmReport.generateJvmReport("C:\\Users\\karth\\eclipse-framework\\FramworkCucumber\\Report\\cucumber.json");
	
}
}