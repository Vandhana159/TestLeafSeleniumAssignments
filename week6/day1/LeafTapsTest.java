package testLeafAssignments.week6.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LeafTapsTest {
	public RemoteWebDriver driver;
	public String fileName,sheetName;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preconditions(String url, String username, String password) {
		//1	Launch the browser
		//Driver object
		driver = new ChromeDriver();
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//2	Enter the username
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys(username);
		//3	Enter the password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(password);
		//4	Click Login -partial attribute
		driver.findElement(By.xpath("//input[contains(@class,'deco')]")).click();
		//5	Click crm/sfa link - partial visible text
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
	}
	@AfterMethod
	public void postconditions() {
		  System.out.println(driver.getTitle());
		    driver.close();
	}
	@DataProvider
	public String[][] sendData() throws IOException{
		return ReadDataFromExcel.excelDatas(fileName,sheetName);
	}
}
