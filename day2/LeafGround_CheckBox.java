package testLeafAssignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//Done
public class LeafGround_CheckBox {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Basic Checkbox
		driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget']/div)[2]")).click();
		Thread.sleep(3000);
		boolean radio = driver.findElement(By.xpath("(//div[@id='j_idt87:j_idt89']//div)[2]")).isEnabled();
		if(radio)
			System.out.println("Basic checkbox is clicked");
		else
			System.out.println("Basic checkbox is not clicked");
		//Notification
		driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget'])[2]/div[2]")).click();
		//Choose your favorite language(s)
		driver.findElement(By.xpath("(//table[@class='ui-selectmanycheckbox ui-widget']//tr//div[1]/div)[2]")).click();
		driver.findElement(By.xpath("//table[@id='j_idt87:basic']/tbody[1]/tr[1]/td[2]/div[1]/div[2]")).click();
		//Tri State Checkbox
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']/div[2]")).click();
		System.out.println("Alert message: "+driver.findElement(By.xpath("//span[text()='State has been changed.']/following::p")).getText());
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']/div[2]")).click();
		Thread.sleep(1000);
		System.out.println("Alert message: "+driver.findElement(By.xpath("//span[text()='State has been changed.']/following::p")).getText());
		//Toggle Switch
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		System.out.println("Alert message: "+driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText());
		//Verify if check box is disabled
		boolean check = driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox ui-chkbox')])[3]/div/input")).isEnabled();
		//System.out.println(check);
		if(!check)
			System.out.println("Check box is disabled");
		else
			System.out.println("Check box is enabled");
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s']")).click();
		driver.findElement(By.xpath("//li[@data-item-value='London']/div/div[2]")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Istanbul']/div/div[2]")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Rome']/div/div[2]")).click();
		driver.findElement(By.xpath("//span[@class ='ui-icon ui-icon-circle-close']")).click();
		driver.close();
	}

}
