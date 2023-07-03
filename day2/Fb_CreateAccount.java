package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Assignment:1
 * Create an account in FaceBook using implict wait and xpath
 */
public class Fb_CreateAccount {
	public static void main(String[] args) {
		// Step 1: Download and set the path 
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nanditha");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Harsha");
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("987456123");
		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456");
		// Step 11: Handle all the three drop downs
		//Date dropdown
		WebElement dateDropDown = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select date = new Select(dateDropDown);
		date.selectByValue("15");
		//Month Dropdown
		WebElement monthDropDown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select month = new Select(monthDropDown);
		month.selectByVisibleText("Sep");
		//Year Dropdown
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select year = new Select(yearDropDown);
		year.selectByValue("2009");
		// Step 12: Select the radio button "Female"( A normal click will do for this step) 
		driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[@value='1']")).click();
		driver.close();         		
	}
}
