package testLeafAssignments.week5.day1.leaftaps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LeafTapsTest {
	public ChromeDriver driver;
	@BeforeClass
	public void preconditions() {
		//1	Launch the browser
		//Driver object
		driver = new ChromeDriver();
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
	}
	@AfterClass
	public void postconditions() {
		  System.out.println(driver.getTitle());
		    driver.close();
	}
}
