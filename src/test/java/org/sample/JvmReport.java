package org.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {

	public static void generateJvmReport(String jsonFile) {
		
		File reportdirectory = new File("C:\\Users\\karth\\eclipse-framework\\FramworkCucumber\\Report");
		
		Configuration configuration = new Configuration(reportdirectory, "Adacitin Select and Booking page");
		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Browser version", "86");
		configuration.addClassifications("Module", "Booking");
		configuration.addClassifications("Sprint", "-");
		configuration.addClassifications("OS", "windows");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		

	}
}
