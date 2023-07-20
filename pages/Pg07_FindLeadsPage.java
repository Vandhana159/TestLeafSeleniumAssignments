package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg07_FindLeadsPage extends ProjectSpecificMethod{
	public Pg07_FindLeadsPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public Pg07_FindLeadsPage clickOnPhoneSearch() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg07_FindLeadsPage enterPhoneNumber(String phoneNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg07_FindLeadsPage clickOnFindLead() throws InterruptedException  {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg07_FindLeadsPage captureFirstLeadId() throws InterruptedException {
		Thread.sleep(3000);
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("Lead id "+leadId);
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg07_FindLeadsPage captureFirstLeadIdName() throws InterruptedException {
		Thread.sleep(3000);
		firstName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
		System.out.println("First displayed Name is "+firstName);
	
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg06_ViewLeadPage clickOnFirstLeadId(){
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new Pg06_ViewLeadPage(driver);
	}
	public Pg07_FindLeadsPage enterLeadId() {
		System.out.println("Lead Id "+leadId);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		return new Pg07_FindLeadsPage(driver);
	}
	public void VerifyDeletedLeadId() throws InterruptedException {
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(data);
		if(data.equalsIgnoreCase("No records to display"))
			System.out.println("Data deleted successfully");
		else
			System.out.println("Data deletion failed");
	}
	public Pg07_FindLeadsPage enterFirstName(String fName) {
		driver.findElement(By.xpath("(//span[text()='Advanced']/following::input)[2]")).sendKeys(fName);
		return new Pg07_FindLeadsPage(driver);
	}
	public Pg07_FindLeadsPage enterEmailId(String emailId) {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(emailId);
		return new Pg07_FindLeadsPage(driver);
	}
}
