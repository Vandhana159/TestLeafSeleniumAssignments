package testLeafAssignments.week5.day1.leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditLead extends LeafTapsTest{
	@Test
public void funcEditLead() {
			//6. Click on Create Lead 
			driver.findElement(By.linkText("Create Lead")).click();
			//7. Enter CompanyName Field Using id Locator
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			//8. Enter FirstName Field Using id Locator
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vandhana");
			//9. Enter LastName Field Using id Locator
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M S");
			//10. Enter FirstName(Local) Field Using id Locator
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vandhana");
			//11. Enter Department Field Using any Locator of Your Choice
			driver.findElement(By.name("departmentName")).sendKeys("Testing-Selenium");
			//12. Enter Description Field Using any Locator of your choice
			driver.findElement(By.name("description")).sendKeys("Selenium May 27 Weekend batch");
			//13. Enter your email in the E-mail address Field using the locator of your choice
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vandhanaKrishh@gmail.com");
			//14. Select State/Province as NewYork Using Visible Text
			WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
			Select sc =new Select(dropDown);	
		    sc.selectByVisibleText("New York");
			//15. Click on Create Button
		    driver.findElement(By.className("smallSubmit")).click();
		    //16. Click on edit button
		    driver.findElement(By.linkText("Edit")).click();
		    //17. Clear the Description Field using .clear()
		    driver.findElement(By.name("description")).clear();
		    //18. Fill ImportantNote Field with Any text
		    driver.findElement(By.name("importantNote")).sendKeys("Selenium May 27 Weekend batch");
		    //19. Click on update button 
		    driver.findElement(By.className("smallSubmit")).click();
			
		    
}
}
