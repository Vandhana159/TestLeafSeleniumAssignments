package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/leaftaps/features/TC01_Login.feature", glue ="stepdefinition",monochrome = true,publish=true)
public class TC01_LoginRunnerClass extends AbstractTestNGCucumberTests{
}
