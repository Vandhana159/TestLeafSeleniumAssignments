package testLeafAssignments.week5.day1.servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNowBaseClass{
	@Test
	public void funcDeleteIncident()  {
		//4. Search for the existing incident and navigate into the incident
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/a")).click();
		String incidentNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident number : "+incidentNo);
		//5. Delete the incident
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		//SweetAlert
		driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
		//6. Verify the deleted incident
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNo);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		String message = "No records to display";
		String text = driver.findElement(By.xpath("//table[@id='incident_table']/following-sibling::div[1]")).getText();
		if(message.equalsIgnoreCase(text))
		{
			System.out.println("Incident has been deleted successfully");
		}
		else
			System.out.println("Incident deletetion failed");
	}

}
