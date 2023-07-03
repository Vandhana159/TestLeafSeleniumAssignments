package testLeafAssignments.week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver =new ChromeDriver();
		//1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//2.search as oneplus 9 pro 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		//3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("1st product price "+price);
		Thread.sleep(2000);
		//4. Print the number of customer ratings for the first displayed product
		driver.findElement(By.xpath("//span[@class='a-declarative']")).click();
		String rating = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
		System.out.println("1st product rating "+rating);
		//5. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		//6. Take a screen shot of the product displayed
		  //window handling 
		Set<String> openedWindows = driver.getWindowHandles();
		List<String> openedWindowsList = new LinkedList<String>(openedWindows);
		driver.switchTo().window(openedWindowsList.get(1));
		Thread.sleep(3000);
		System.out.println("New tab title: "+driver.getTitle());
		
		File product = driver.getScreenshotAs(OutputType.FILE);
		File path = new File("./screenshots/productDisplayed.jpeg");
		FileUtils.copyFile(product, path);
		System.out.println("Product screen shot saved");
		
		//7. Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		//8. Get the cart subtotal and verify if it is correct.   -- not fetching 
		Thread.sleep(3000);
		Thread.sleep(3000);
		String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText().replaceAll(".00", "");
		System.out.println("Subtotal of the product is "+subtotal);
		String phPrice = price.replaceAll("[^a-zA-Z0-9]", "");
		String subTotalPrice = subtotal.replaceAll("[^a-zA-Z0-9]", "");
		int price1 = Integer.parseInt(phPrice);
		int price2 = Integer.parseInt(subTotalPrice);
		System.out.println("price1 "+price1 +"\nprice2 "+price2);
		if(price1 == price2)
			System.out.println("Item added successfully");
		else
			System.out.println("Add to cart failed");
		//9.close the browser
		driver.quit();
	}

}
