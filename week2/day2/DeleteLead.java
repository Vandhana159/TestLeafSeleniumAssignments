package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
public static void main(String[] args) throws InterruptedException {
	//1	Launch the browser
	//Driver object
	ChromeDriver driver = new ChromeDriver();
	//1. Launch URL "http://leaftaps.com/opentaps/control/login"
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
	//8	Click on Phone
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	//9	Enter phone number
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("987654321");
	//10	Click find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(3000);
	//11	Capture lead ID of First Resulting lead
	String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	System.out.println("Lead id "+leadId);
	//12	Click First Resulting lead
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	//13	Click Delete
	driver.findElement(By.xpath("//a[text()='Delete']")).click();
	//14	Click Find leads
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	//15	Enter captured lead ID
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
	//16	Click find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(3000);
	//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	//div[@class='x-toolbar x-small-editor']//div[1]
	String data = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	System.out.println(data);
	if(data.equalsIgnoreCase("No records to display"))
		System.out.println("Data deleted successfully");
	else
		System.out.println("Data deletion failed");
	//18	Close the browser (Do not log out)
	driver.close();
}
}
