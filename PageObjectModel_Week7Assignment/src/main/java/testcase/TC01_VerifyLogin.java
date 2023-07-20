package testcase;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC01_VerifyLogin extends ProjectSpecificMethod{
	@Test
	public void verifyLoginModule() {
		Pg01_LoginPage Login = new Pg01_LoginPage(driver);
		Login.enterUserName().enterPassword().clickLogin();
	}
}
