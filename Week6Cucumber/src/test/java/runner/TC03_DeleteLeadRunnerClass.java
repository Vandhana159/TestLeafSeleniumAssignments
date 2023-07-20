package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC03_DeleteLead.feature", glue ="stepdefinition",monochrome = true,publish=true)
public class TC03_DeleteLeadRunnerClass extends AbstractTestNGCucumberTests{

}
