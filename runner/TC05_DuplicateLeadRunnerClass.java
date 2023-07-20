package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC05_DuplicateLead.feature", glue ="stepdefinition",monochrome = true,publish=true)

public class TC05_DuplicateLeadRunnerClass extends AbstractTestNGCucumberTests{

}
