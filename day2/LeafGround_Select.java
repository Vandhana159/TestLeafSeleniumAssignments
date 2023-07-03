package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGround_Select {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/select.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	//Which is your favorite UI Automation tool?
	WebElement favAiDropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
	Select sc =new Select(favAiDropDown);	
    sc.selectByVisibleText("Selenium");
     
    //Choose your preferred country.
    driver.findElement(By.xpath("(//div[@id='j_idt87:country']//div)[3]")).click();
    driver.findElement(By.xpath("//li[text()='India']")).click();
    
    //Confirm Cities belongs to Country is loaded
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='j_idt87:city']//div[3]")).click();
    driver.findElement(By.xpath("//li[text()='Bengaluru']")).click();
 
  
    //Choose the Course
    driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
    driver.findElement(By.xpath("//li[@data-item-value='Playwright']")).click();
 
   //Choose language randomly
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='j_idt87:lang']/div[3]")).click();
    driver.findElement(By.xpath("//li[text()='Malayalam']")).click();
 
    //Select 'Two' irrespective of the language chosen
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='j_idt87:value']//div[3]")).click();
    driver.findElement(By.xpath("//li[text()='മൂന്ന്']")).click();
 
    driver.close();
}
}
