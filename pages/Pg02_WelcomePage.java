package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg02_WelcomePage extends ProjectSpecificMethod{
	public Pg02_WelcomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg03_MyHomePage clickOnCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new Pg03_MyHomePage(driver);
	}
	public Integer clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		Integer i = 78; 
		return i;
	}
}
