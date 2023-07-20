package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;

public class Pg06_ViewLeadPage extends ProjectSpecificMethod{
	public Pg06_ViewLeadPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public Pg04_LeadsPage clickOnDelete() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		return new Pg04_LeadsPage(driver);
	}
	public Pg06_ViewLeadPage verifyTitle() throws InterruptedException {
		Thread.sleep(3000);
		String currTitle = driver.getTitle();
		if(currTitle.equalsIgnoreCase("View Lead | opentaps CRM"))
			System.out.println("Navigated to "+currTitle);
		else
			System.out.println("Navigated to incorrect page");
		return new Pg06_ViewLeadPage(driver);
	}
	public Pg08_OpentapsCrmPage clickOnEdit(){
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		return new Pg08_OpentapsCrmPage(driver);
		}
	public Pg08_OpentapsCrmPage verifyUpdatedCompanyName(String cName) {
		String companyName= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if(companyName.equals(cName+" ("+leadId+")"))
			{
		System.out.println("Company name updated successfully");
			}
		else
			System.out.println("Company name update failed");
		return new Pg08_OpentapsCrmPage(driver);
			}
	public Pg08_OpentapsCrmPage verifyFirstNameAndCompanyName(String cName,String fName) {
		String companyName= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		String firstName= driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if(companyName.contains(cName) && firstName.equalsIgnoreCase(fName) )
			{
		System.out.println("Company name and FirstName are correct");
			}
		else
			System.out.println("Company name and FirstName are incorrect");
		return new Pg08_OpentapsCrmPage(driver);
			}
	public Pg08_OpentapsCrmPage verifyFirstName() {
		
		String fName= driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if(fName.equalsIgnoreCase(firstName) )
			System.out.println("FirstName is correct");
		else
			System.out.println("FirstName are incorrect");
		return new Pg08_OpentapsCrmPage(driver);
			}
	
	public TC09_DuplicateLeadPage clickOnDuplicateLead() {
		driver.findElement(By.xpath("//div/a[text()='Duplicate Lead']")).click();
		return new TC09_DuplicateLeadPage(driver);
	}
	}
