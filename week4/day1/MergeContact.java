package testLeafAssignments.week4.day1;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--diable-notifications");
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver =new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//a/img)[1]")).click();
		//8. Click on First Resulting Contact
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> win = new LinkedList<String>(windowHandle);
		System.out.println(win);
		driver.switchTo().window(win.get(1));
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.switchTo().window(win.get(0));
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//a/img)[2]")).click();
		//10. Click on Second Resulting Contact
		Set<String> windowHandle1 = driver.getWindowHandles();
		List<String> win1 = new LinkedList<String>(windowHandle1);
		System.out.println(win1);
		driver.switchTo().window(win1.get(1));
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(win1.get(0));
		System.out.println(driver.getTitle());
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.className("buttonDangerous")).click();
		//12. Accept the Alert
		Alert a = driver.switchTo().alert();
		System.out.println("Alert messsage "+a.getText());
		a.accept();
		
		//13. Verify the title of the page
		System.out.println(driver.getTitle());
		driver.close();
	}

}
