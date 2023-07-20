package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC06_VerifyDuplicateFromExistingLead extends ProjectSpecificMethod{
		@BeforeTest
		public void setValues() {
			fileName = "LeafTapsData";
			sheetName = "DuplicateLeadFromExisting";
		}
		@Test(dataProvider = "sendData")
		public void verifyDuplicateFromExistingLeadFunctionality(String eMailId) throws InterruptedException {
			Pg01_LoginPage Login = new Pg01_LoginPage(driver);
			Login.enterUserName().
			enterPassword().
			clickLogin().
			clickOnCRMSFA().
			clickOnLeads().clickOnFindLeads().enterEmailId(eMailId).clickOnFindLead().captureFirstLeadIdName().clickOnFirstLeadId().
			clickOnDuplicateLead().verifyTitle().clickOnCreateButton().verifyFirstName();			
		}
}