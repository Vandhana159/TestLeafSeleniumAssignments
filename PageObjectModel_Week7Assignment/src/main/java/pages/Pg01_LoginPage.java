package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg01_LoginPage extends ProjectSpecificMethod {
	public Pg01_LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg01_LoginPage enterUserName() {
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		return this;
	}
	public Pg01_LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	public Pg02_WelcomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new Pg02_WelcomePage(driver);
	}
}
