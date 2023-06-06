package testLeafAssignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//2	Enter the username
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demoSalesManager");
		//3	Enter the password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		//4	Click Login -partial attribute
		driver.findElement(By.xpath("//input[contains(@class,'deco')]")).click();
		//5	Click crm/sfa link - partial visible text
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//9	Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mayaKrishh@gmail.com");
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
		//17	Close the browser (Do not log out)
		driver.close();
	}
}
