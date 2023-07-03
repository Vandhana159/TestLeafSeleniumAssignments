package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
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
			//5. Click on contacts Button
			driver.findElement(By.linkText("Contacts")).click();
			//6. Click on Create Contact
			driver.findElement(By.linkText("Create Contact")).click();
			//7. Enter FirstName Field Using id Locator
			driver.findElement(By.id("firstNameField")).sendKeys("Maya");
			//8. Enter LastName Field Using id Locator
			driver.findElement(By.id("lastNameField")).sendKeys("Krishnan");
			//9. Enter FirstName(Local) Field Using id Locator
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Maya");
			//10. Enter LastName(Local) Field Using id Locator
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Krish");
			//11. Enter Department Field Using any Locator of Your Choice
			driver.findElement(By.name("departmentName")).sendKeys("Sales");
			//12. Enter Description Field Using any Locator of your choice
			driver.findElement(By.id("createContactForm_description")).sendKeys("Part of Sales Team");
			//13. Enter your email in the E-mail address Field using the locator of your choice
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("mayaKrishnan@gmail.com");
			driver.findElement(By.id("createContactForm_primaryPhoneAreaCode")).sendKeys("91");
			driver.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys("987654321");
			//14. Select State/Province as NewYork Using Visible Text
			Select sc = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
			sc.selectByVisibleText("New York");
			//15. Click on Create Contact
			driver.findElement(By.xpath("//input[contains(@value,'Create')]")).click();
			//16. Click on edit button 
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			//17. Clear the Description Field using .clear
			driver.findElement(By.xpath("//textarea[@name='description']")).clear();
			//18. Fill ImportantNote Field with Any text
			driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Part of Sales Team");
			//19. Click on update button using Xpath locator
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			//20. Get the Title of Resulting Page.
			if(driver.getTitle().equalsIgnoreCase("View Contact | opentaps CRM"))
				System.out.println(driver.getTitle());
			else
				System.out.println("Update Failed/Failed to load page");
			//Close window
			driver.close();
}
}
