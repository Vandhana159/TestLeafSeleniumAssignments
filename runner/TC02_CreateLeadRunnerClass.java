package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC02_CreateLead.feature", glue ="stepdefinition",monochrome = true,publish=true)
public class TC02_CreateLeadRunnerClass extends AbstractTestNGCucumberTests{
	
}
