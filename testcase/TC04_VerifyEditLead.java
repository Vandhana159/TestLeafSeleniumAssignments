package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC04_VerifyEditLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setValues() {
		fileName = "LeafTapsData";
		sheetName = "EditLeads";
	}
	@Test(dataProvider = "sendData")
	public void verifyEditLeadFunctionality(String cName,String fName) throws InterruptedException {
		Pg01_LoginPage Login = new Pg01_LoginPage(driver);
		Login.enterUserName().
		enterPassword().
		clickLogin().
		clickOnCRMSFA().
		clickOnLeads().
		clickOnFindLeads().enterFirstName(fName).clickOnFindLead().captureFirstLeadId().clickOnFirstLeadId().
		verifyTitle().clickOnEdit().changeCompayName(cName).clickOnUpdate().verifyUpdatedCompanyName(cName);;
		}
}

