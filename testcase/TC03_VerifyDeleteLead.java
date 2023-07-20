package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC03_VerifyDeleteLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setValues() {
		fileName = "LeafTapsData";
		sheetName = "DeleteLead";
	}
	@Test(dataProvider = "sendData")
	public void verifyDeleteLeadFunctionality(String phNumber) throws InterruptedException {
		Pg01_LoginPage Login = new Pg01_LoginPage(driver);
		Login.enterUserName().
		enterPassword().
		clickLogin().
		clickOnCRMSFA().
		clickOnLeads().
		clickOnFindLeads().clickOnPhoneSearch().enterPhoneNumber(phNumber).clickOnFindLead()
		.captureFirstLeadId().clickOnFirstLeadId().clickOnDelete().clickOnFindLeads().enterLeadId()
		.clickOnFindLead().VerifyDeletedLeadId();
			}

}
