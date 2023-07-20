package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg04_LeadsPage extends ProjectSpecificMethod{
	public Pg04_LeadsPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg05_CreateLeadPage clickOnCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new Pg05_CreateLeadPage(driver);
	}
	public Pg07_FindLeadsPage clickOnFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new Pg07_FindLeadsPage(driver);
	}
	
}