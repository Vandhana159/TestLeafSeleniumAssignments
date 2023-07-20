package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC02_VerifyCreateLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setValues() {
		fileName = "LeafTapsData";
		sheetName = "CreateLead";
	}
	@Test(dataProvider = "sendData")
	public void verifyCreateLeadFunctionality(String cName,String fName,String lName,String fNameLocal,String phNumber,String deptName,String desc,String eMailId,String state) throws InterruptedException {
		Pg01_LoginPage Login = new Pg01_LoginPage(driver);
		Login.enterUserName().
		enterPassword().
		clickLogin().
		clickOnCRMSFA().
		clickOnLeads().
		clickOnCreateLead().
		enterCompanyName(cName).
		enterFirstName(fName).
		enterLastName(lName).
		enterFirstNameLocal(fNameLocal).
		enterPhoneNumber(phNumber).
		enterDepartmentName(deptName).
		enterDescription(desc).
		enterEmailId(eMailId).
		selectState(state).
		clickOnCreateLeadButton().
		verifyTitle();
	}

}
