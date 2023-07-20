package testLeafAssignments.week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends LeafTapsTest{
	@BeforeTest
	public void setValues() {
		fileName = "LeafTapsData";
		sheetName = "DuplicateLead";
	}
	@Test(dataProvider = "sendData")
public  void funcDuplicateLeadWithNewCompany(String cName,String fName,String lName,String fNameLocal,String deptName,String desc,String eMailId,String state
		,String cNameNew,String fNameNew) {
		//System.out.println(cName+" "+fName+" "+lName+" "+fNameLocal+" "+deptName+" "+desc+" "+eMailId+" "+state+" "+cNameNew+" "+fNameNew);
	//6. Click on Create Lead 
	driver.findElement(By.linkText("Create Lead")).click();
	//7. Enter CompanyName Field Using id Locator
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	//8. Enter FirstName Field Using id Locator
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	//9. Enter LastName Field Using id Locator
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	//10. Enter FirstName(Local) Field Using id Locator
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNameLocal);
	//11. Enter Department Field Using any Locator of Your Choice
	driver.findElement(By.name("departmentName")).sendKeys(deptName);
	//12. Enter Description Field Using any Locator of your choice
	driver.findElement(By.name("description")).sendKeys(desc);
	//13. Enter your email in the E-mail address Field using the locator of your choice
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(eMailId);
	//driver.findElement(By.name("primaryEmail")).sendKeys(eMailId);
	//14. Select State/Province as NewYork Using Visible Text
	WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
	Select sc =new Select(dropDown);	
    sc.selectByVisibleText(state);
	//15. Click on Create Button
    driver.findElement(By.className("smallSubmit")).click();
    //16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
    System.out.println(driver.getTitle());
    //17. Click on Duplicate button
    driver.findElement(By.linkText("Duplicate Lead")).click();
    //18. Clear the CompanyName Field using .clear() And Enter new CompanyName
    driver.findElement(By.id("createLeadForm_companyName")).clear();
    driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cNameNew);
    //19.Clear the FirstName Field using .clear() And Enter new FirstName
    driver.findElement(By.id("createLeadForm_firstName")).clear();
    driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fNameNew);
    //20.Click on Create Lead Button
    driver.findElement(By.name("submitButton")).click();


}
}
