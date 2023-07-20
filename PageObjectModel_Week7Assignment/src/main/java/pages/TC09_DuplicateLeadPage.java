package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class TC09_DuplicateLeadPage extends ProjectSpecificMethod{
	public TC09_DuplicateLeadPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public TC09_DuplicateLeadPage verifyTitle() throws InterruptedException {
		Thread.sleep(3000);
		String currTitle = driver.getTitle();
		if(currTitle.equalsIgnoreCase("Duplicate Lead | opentaps CRM"))
			System.out.println("Navigated to "+currTitle);
		else
			System.out.println("Navigated to wrong page");
		return new TC09_DuplicateLeadPage(driver);
	}
	public TC09_DuplicateLeadPage changeCompayName(String cName) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cName);
		return new TC09_DuplicateLeadPage(driver);
	}
	public TC09_DuplicateLeadPage changeFirstName(String fName) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
		return new TC09_DuplicateLeadPage(driver);
	}
	public Pg06_ViewLeadPage clickOnCreateButton() {
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		return new Pg06_ViewLeadPage(driver);
	}
}
