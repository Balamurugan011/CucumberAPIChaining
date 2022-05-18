package org.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReports {
	public static void generateReports(String json) {

		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\CucumberApiChaining\\target");
		Configuration configuration = new Configuration(file, "VelsBUsiness");
		configuration.addClassifications("Browser Name", "ChromeBrowser");
		configuration.addClassifications("Sprint no", "12");
		configuration.addClassifications("Platform", "Windows-10");
		configuration.addClassifications("Environment", "UAT");

		List<String> li = new ArrayList<String>();
		li.add(json);
		ReportBuilder builder = new ReportBuilder(li, configuration);
		builder.generateReports();

	}

}
