package testLeafAssignments.week4.day2;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		//1) Go to https://www.nykaa.com/
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//2) Mouseover on Brands and Search L'Oreal Paris
		Actions action = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='scroller-container']/div/a")).click();
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris:"))
			System.out.println("Navigated to Loreal Paris Brand Page");
		else
			System.out.println("Failed to navigate");
		//5) Click sort By and select customer top rated
		action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-name']"))).perform();
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Category']"))).perform();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Hair']"))).perform();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Hair']"))).perform();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Shampoo']"))).perform();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//7) Click->Concern->Color Protection
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Concern']"))).perform();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		//8)check whether the Filter is applied with Shampoo
		String filter = driver.findElement(By.xpath("(//div[@class='css-3i7s5s']/span)[2]")).getText();
		String filter1 = driver.findElement(By.xpath("(//div[@class='css-3i7s5s']/span)[1]")).getText();
		if(filter.contains("Protection") && filter1.contains("Shampoo"))
			System.out.println("Filter applied successfully");
		else
			System.out.println("Failed to apply filter");
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-d5z3ro']/a")).click();
		//10) GO to the new window and select size as 175ml
		Set<String> openedWindows = driver.getWindowHandles();
		List<String> openedWindowsList = new LinkedList<String>(openedWindows);
		driver.switchTo().window(openedWindowsList.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		//11) Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("MRP Of the Product "+mrp);
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		//13) Go to Shopping Bag 
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		//14) Print the Grand Total amount
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		String grandTotal = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("Grand total = "+grandTotal);
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		//17) Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
		String price = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		System.out.println("Price = "+price);
		if(grandTotal.equalsIgnoreCase(price))
		{
			System.out.println("Both price are same");
		}
		else
			System.out.println("Price varies");
		//18) Close all windows
		driver.quit();
	}

}
