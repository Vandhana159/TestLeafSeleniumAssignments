package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC06_DupLeadFromExisting.feature", glue ="stepdefinition",monochrome = true,publish=true)

public class TC06_DupLeadFromExistingRunnerClass {

}
