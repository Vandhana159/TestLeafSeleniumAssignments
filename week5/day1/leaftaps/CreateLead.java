package testLeafAssignments.week5.day1.leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead extends LeafTapsTest{
	@Test
public void funcCreateLead() {
		//6. Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();
		//7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		//8. Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Maya");
		//9. Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mayon");
		//10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("MayaKrish");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("987654321");
		//11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.name("departmentName")).sendKeys("Testing-Selenium");
		//12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.name("description")).sendKeys("Selenium May 27 Weekend batch");
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mayaKrishh@gmail.com");
		//14. Select State/Province as NewYork Using Visible Text
		WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select sc =new Select(dropDown);	
	    sc.selectByVisibleText("New York");
		//15. Click on Create Button
	    driver.findElement(By.className("smallSubmit")).click();		
}
}
