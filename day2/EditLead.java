package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
		//Driver object
		ChromeDriver driver = new ChromeDriver();
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//2. Enter UserName and Password Using Id Locator
		WebElement userElement = driver.findElement(By.id("username"));
		userElement.sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		//4. Click on CRM/SFA Link	
		driver.findElement(By.linkText("CRM/SFA")).click();
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//8	Enter first name
		driver.findElement(By.xpath("(//span[text()='Advanced']/following::input)[2]")).sendKeys("Maya");
		//9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String leadId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		//10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		Thread.sleep(3000);
		//11 Verify title of the page
		if(driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM"))
			{
		System.out.println("Selected lead datas is displayed");
		//12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//13 Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Amazon");
		//14 Click Update
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		//15 Confirm the changed name appears
		String companyName= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		//System.out.println("Amazon ("+leadId+")");
		if(companyName.equals("Amazon ("+leadId+")"))
			{
		System.out.println("Company name updated successfully");
		//16 Close the browser (Do not log out)
		driver.close();
			}
		else
			System.out.println("Company name update failed");
			}
		else
			System.out.println("Failed to displayed");
}
		

}
