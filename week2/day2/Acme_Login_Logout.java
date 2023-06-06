package testLeafAssignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Acme_Login_Logout {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	//1. Load url "https://acme-test.uipath.com/login"
	driver.get("https://acme-test.uipath.com/login");
	driver.manage().window().maximize();
	//2. Enter email as "kumar.testleaf@gmail.com"
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
	//3. Enter Password as "leaf@12"
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
	//4. Click login button
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//Thread.sleep(3000);
	//5. Get the title of the page and print
	//if(driver.getTitle().equalsIgnoreCase("ACME System 1 - Dashboard"))
	//{
	System.out.println(driver.getTitle());
	//6. Click on Log Out
	driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	//7. Close the browser (use -driver.close())
	driver.close();
}	
}
