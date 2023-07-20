package testLeafAssignments.week5.day1.servicenow;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AssigningIncident extends ServiceNowBaseClass{
	@Test
	public void funAssigningIncident() {
		//4. Search for the existing incident and click on  the incident
		String incidentNo = dom.findElementByXPath("//td[@class='vt']//a[1]").getText();
		System.out.println("Incident no : "+incidentNo);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNo);
	
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']//a[1]")).click();
	
		//5. Click View: Self Service and select Default View from the pop up
		driver.findElement(By.xpath("//span[text()=' View: Self Service']")).click();
		driver.findElement(By.xpath("//div[text()='Default view']")).click();
		
		//6. Click on the search icon under Assignment group
		driver.findElement(By.xpath("//button[@name='lookup.incident.assignment_group']//span[1]")).click();
		
		//7. Enter 'Software' in the search box from the window opened and press Enter
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> win1 = new LinkedList<String>(windowHandle1);
		System.out.println(win1);
		//switching access to newly opened window
		driver.switchTo().window(win1.get(1));
		String assignmentGroup = "Software";
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input")).sendKeys(assignmentGroup);
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input")).sendKeys(Keys.ENTER);
		
		//8. Click 'Software' from the results displayed
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(win1.get(0));

		//9. Update the incident with Work Notes
		//frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		//Actions action = new Actions(driver);
		WebElement workNotes = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"));
		//action.scrollToElement(workNotes).perform();
		workNotes.sendKeys("Incident assigned to software group");
		driver.findElement(By.xpath("//button[text()='Post']")).click();
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		//10. Verify the Assignment group for the incident
		driver.findElement(By.xpath("//span[text()=' View: Self Service']")).click();
		driver.findElement(By.xpath("//div[text()='Default view']")).click();
		
		String value = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getAttribute("value");
		System.out.println("Assignment Group "+value);
		if(value.equalsIgnoreCase(assignmentGroup))
			System.out.println("Updated successfully");
		else
			System.out.println("Update failed");
	}

}
