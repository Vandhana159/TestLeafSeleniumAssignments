package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC04_EditLead.feature", glue ="stepdefinition",monochrome = true,publish=true)
public class TC04_EditLeadRunnerClass extends AbstractTestNGCucumberTests{

}
