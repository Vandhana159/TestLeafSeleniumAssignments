package testLeafAssignments.week5.day1.servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateExistingIncident extends ServiceNowBaseClass{
	@Test
	public void funUpdateExistingIncident(){
		
		//4. Search for the existing incident and click on the incident
		String incidentNo = dom.findElementByXPath("//td[@class='vt']//a[1]").getText();
		System.out.println("Incident no : "+incidentNo);
		dom.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNo);
		dom.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
		dom.findElementByXPath("//td[@class='vt']//a[1]").click();
		
		//5. Update the incidents with Urgency as High and State as In Progress
		Select urgency = new Select(driver.findElement(By.xpath("//select[@id='incident.urgency']")));
		urgency.selectByVisibleText("1 - High");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='incident.state']")));
		String incState = "In Progress";
		state.selectByVisibleText(incState);
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		
		//6. Verify the priority and state
		driver.findElement(By.xpath("//td[@class='vt']//a[1]")).click();
		String priority = driver.findElement(By.xpath("(//ul[@class='sn-widget-list sn-widget-list-table']/li[2]/span[2]/span)[1]")).getText();
		System.out.println("Incident priority :"+priority);
		String incidentState = driver.findElement(By.xpath("//ul[@class='sn-widget-list sn-widget-list-table']/li/span[2]/span")).getText();
		System.out.println("Incident State :"+incidentState);
		if(incidentState.equalsIgnoreCase(incState))
			System.out.println("Incident state is updated successfully");
		else
			System.out.println("Failed to update incident state");		
		if(priority.equalsIgnoreCase("3 - Moderate"))
			System.out.println("Incident priority is updated successfully");
		else
			System.out.println("Failed to update incident priority");
	}
	
}
