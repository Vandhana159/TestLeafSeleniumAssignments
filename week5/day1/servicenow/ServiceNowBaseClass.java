package testLeafAssignments.week5.day1.servicenow;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.sukgu.Shadow;

public class ServiceNowBaseClass {
	public ChromeDriver driver ;
	public Shadow dom ;
	public static WebElement frame1 ;
	@BeforeClass
	public void preCondition() {
		driver = new ChromeDriver();
		
		//1. Launch ServiceNow application
		driver.get("https://dev92929.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().window().maximize();
		
		//2. Login with valid credentials (refer the document to create the instance)
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("K92B%@sEunFs");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Enter Incident in filter navigator and press enter -- Shadow Element
		dom = new Shadow(driver);
		dom.setImplicitWait(20);
		WebElement allMenu = dom.findElementByXPath("//div[@aria-label='All']");
		allMenu.click();
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		dom.findElementByXPath("//span/mark[text()='Incidents']").click();
		
		frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
	}
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
