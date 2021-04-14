package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		monochrome = true,
		features = "src/test/java/cucumber_features",
		dryRun = true,
		plugin = {"pretty" ,"html: test-output/cucumber-report/cucumber.html",
				"json: test-output/cucumber-report/cucumber.json",
		"junit: test-output/cucumber-report/cucumber.xml"}		
		)

public class BDDTestRunner {
	//Run this from Maven or as JUnit
}