package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg08_OpentapsCrmPage extends ProjectSpecificMethod{
	public Pg08_OpentapsCrmPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg08_OpentapsCrmPage changeCompayName(String cName) {
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(cName);
		return new Pg08_OpentapsCrmPage(driver);
	}
	public Pg06_ViewLeadPage clickOnUpdate() {
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		return new Pg06_ViewLeadPage(driver);
	}
	
	
	
}
