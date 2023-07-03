package testLeafAssignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//Done
public class LeafGround_Buttons {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		//Click and Confirm title.
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		if(pageTitle.equalsIgnoreCase("Dashboard"))
		{
			System.out.println("Click option is nagivating to dashboard");
			driver.navigate().back();
		}
		else
			System.out.println("Nagivation to dashboard failed");
		//Confirm if the button is disabled.
		boolean button2 = driver.findElement(By.xpath("//div[@class='grid button-demo']//div[2]/button")).isEnabled();
		if(!button2)
			System.out.println("Button 2 is disabled ");
		else
			System.out.println("Button2 is enabled ");
		
		//Find the position of the Submit button
		Point location = driver.findElement(By.xpath("(//span[text()='Disabled']/following::span[text()='Submit'])[1]")).getLocation();
		System.out.println("Location of Submit button "+location);
		
		//Find the Save button color
		String saveColor = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("color");
		System.out.println("Color of save button is "+saveColor);
		
		//Find the height and width of this button
		WebElement submitButton = driver.findElement(By.xpath("//span[@class='ui-button-icon-right ui-icon ui-c pi pi-bookmark']"));
		System.out.println("height and width of submit button "+submitButton.getSize());
		
		//Mouse over and confirm the color changed
		WebElement success = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));
		String successColor = success.getCssValue("background-color");
		System.out.println("Color of save button is "+successColor);
		
		Actions action = new Actions(driver);
		action.moveToElement(success).perform();
		String successColor1 = success.getCssValue("background-color");//"background"
		System.out.println("Color of save button after mouseover "+successColor1);
		
		if(!(successColor.equalsIgnoreCase(successColor1)))
			System.out.println("Color of the button changes on hover ");
		else
			System.out.println("Color doesn't change on hover");
		
		//Click Image Button and Click on any hidden button--doubt
		 driver.findElement(By.xpath("//span[text()='Image']/parent::button")).click();
		 WebElement hiddenButton = driver.findElement(By.xpath("//span[text()='Secondary']"));
		 action.moveToElement(hiddenButton).click().perform();
		 Thread.sleep(3000);
		 
		//How many rounded buttons are there?
		 int count = driver.findElements(By.xpath("(//div[@class='col-12 md:col-6'])[2]/div[4]/button")).size();
		 System.out.println("Total no of round button = "+count);	
		 driver.close();
		}
}
