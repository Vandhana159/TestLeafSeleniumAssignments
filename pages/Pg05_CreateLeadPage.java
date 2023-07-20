package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethod;

public class Pg05_CreateLeadPage extends ProjectSpecificMethod{
	public Pg05_CreateLeadPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg05_CreateLeadPage enterCompanyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		return this;
	}
	public Pg05_CreateLeadPage enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		return this;
	}
	public Pg05_CreateLeadPage enterLastName(String lname) {
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	return this;
	}
	public Pg05_CreateLeadPage enterFirstNameLocal(String fnameLocal) {
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fnameLocal);
	return this;
	}
	public Pg05_CreateLeadPage enterPhoneNumber(String phNumber) {
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNumber);
	return this;
	}
	public Pg05_CreateLeadPage enterDepartmentName(String deptName) {
	driver.findElement(By.name("departmentName")).sendKeys(deptName);
	return this;
	}
	public Pg05_CreateLeadPage enterDescription(String desc) {
	driver.findElement(By.name("description")).sendKeys(desc);
	return this;
	}
	public Pg05_CreateLeadPage enterEmailId(String eMail) {
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(eMail);
	return this;
	}
	public Pg05_CreateLeadPage selectState(String state) {
	WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
	Select sc =new Select(dropDown);	
    sc.selectByVisibleText(state);
    return this;
	}
	public Pg06_ViewLeadPage clickOnCreateLeadButton() {
    driver.findElement(By.className("smallSubmit")).click();
    return new Pg06_ViewLeadPage(driver);
	}
}
