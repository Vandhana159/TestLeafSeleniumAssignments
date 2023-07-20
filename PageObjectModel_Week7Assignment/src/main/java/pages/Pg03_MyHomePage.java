package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg03_MyHomePage extends ProjectSpecificMethod{
	public Pg03_MyHomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg04_LeadsPage clickOnLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new Pg04_LeadsPage(driver);
	}
}
