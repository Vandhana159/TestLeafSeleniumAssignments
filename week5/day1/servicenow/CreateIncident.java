package testLeafAssignments.week5.day1.servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceNowBaseClass{
	@Test
	public void funCreateIncident() {
		//4. Click on Create new option and fill the mandatory fields
		driver.findElement(By.xpath("//button[contains(@class,'selected_action action_context')]")).click();
		String incidentNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		String description ="Cannot able to login into instance dev31913";
		driver.findElement(By.id("incident.short_description")).sendKeys(description);
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		//5. Verify the newly created incident ( copy the incident number and paste it in search field 
		//and enter then verify the instance number created or not)
		System.out.println("incidentNo "+incidentNo);
		driver.findElement(By.xpath("//select[@role='listbox']")).click();
		driver.findElement(By.xpath("//option[text()='Number']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNo);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']//a[1]")).click();
		String desc = driver.findElement(By.id("incident.short_description")).getAttribute("value");
		if(desc.equalsIgnoreCase(description))
			System.out.println("Incident created successfully \n Incident no :"+incidentNo);
		else
			System.out.println("Failed to create incident");
		}

}
