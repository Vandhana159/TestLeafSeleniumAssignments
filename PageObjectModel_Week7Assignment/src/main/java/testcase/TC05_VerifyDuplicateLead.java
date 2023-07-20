package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.Pg01_LoginPage;

public class TC05_VerifyDuplicateLead extends ProjectSpecificMethod{
		@BeforeTest
		public void setValues() {
			fileName = "LeafTapsData";
			sheetName = "DuplicateLead";
		}
		@Test(dataProvider = "sendData")
		public void verifyDuplicateLeadFunctionality(String cName,String fName,String lName,String fNameLocal,String deptName,String desc,String eMailId,String state,String cNameNew,String fNameNew) throws InterruptedException {
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
			enterDepartmentName(deptName).
			enterDescription(desc).
			enterEmailId(eMailId).
			selectState(state).
			clickOnCreateLeadButton().
			verifyTitle().clickOnDuplicateLead().verifyTitle().changeCompayName(cNameNew).
			changeFirstName(fNameNew).clickOnCreateButton().verifyTitle().verifyFirstNameAndCompanyName(cNameNew, fNameNew);
		}
}
