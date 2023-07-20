package testLeafAssignments.week6.day1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLeadFromExistingRecord extends LeafTapsTest{
	@BeforeTest
	public void setValues() {
		fileName = "LeafTapsData";
		sheetName = "DuplicateLeadFromExisting";
	}
	@Test(dataProvider = "sendData")
	public  void funcDupLeads(String eMailId) throws InterruptedException {
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//9	Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(eMailId);
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//11	Capture name of First Resulting lead
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
		System.out.println("First displayed Name is "+name);
		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		//13	Click Duplicate Lead
		driver.findElement(By.xpath("//div/a[text()='Duplicate Lead']")).click();
		//14	Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		if(title.equalsIgnoreCase("Duplicate Lead | opentaps CRM"))
			System.out.println("Successful");
		else
			System.out.println("Failed");
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//16	Confirm the duplicated lead name is same as captured name
		String duplicateName=driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println("Duplicate record First Name "+duplicateName);
		if(duplicateName.equals(name))
			System.out.println("Successfuly created duplicate lead");
		else
			System.out.println("Duplicate Lead failed");
	}

}
