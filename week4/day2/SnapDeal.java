package testLeafAssignments.week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//update sorting testing conditions
public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//2. Go to Mens Fashion
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct '])[1]"))).perform();
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("(//p/a/span[text()='Sports Shoes'])[1]")).click();
		//4. Get the count of the sports shoes
		String shoesCount = driver.findElement(By.xpath("(//h1[@category='Sports Shoes for Men'])/following-sibling::span")).getText();
		System.out.println("Total shoes count ::"+shoesCount);
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//6. Sort by Low to High
		a.moveToElement(driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/i")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-sorttype='plth']")).click();
		Thread.sleep(2000);
		//7. Check if the items displayed are sorted correctly
		List<WebElement> shoeCount = driver.findElements(By.xpath("//div[@class='lfloat marR10']/span[2]"));
		System.out.println("shoe list "+shoesCount);
		List<Integer> priceList = new ArrayList<Integer>();
		for(int i =0; i < shoeCount.size();i++ )
		{ int price = Integer.parseInt(driver.findElement(By.xpath("(//div[@class='lfloat marR10'])["+(i+1)+"]/span[2]")).getText().replaceAll("Rs. ", ""));
			priceList.add(i, price);
		}
		List<Integer> sortedPriceList = new ArrayList<Integer>();
		sortedPriceList.addAll(priceList);
		Collections.sort(sortedPriceList);
		System.out.println("List of price "+priceList);
		System.out.println("Sorted List of price "+sortedPriceList);
		boolean flag = false;
		int price1,price2 =0;
		for(int i =0; i<shoeCount.size();i++) {
			price1 = priceList.get(i);
			price2 = sortedPriceList.get(i);
			if( price1 == price2 )
				flag = true;
			else
				flag = false;
		}
		if(flag == true)
			System.out.println("Items are sorted successfully");
		else
			System.out.println("Items sorting failed");
		//8.Select the price range (400-600)
		//Start Ranger
		WebElement startPriceSlider = driver.findElement(By.xpath("(//div[@data-filter-type='slider']/div/a)[1]"));
		a.moveToElement(startPriceSlider).perform();
		a.dragAndDropBy(startPriceSlider, 7,0).perform();
		//End Ranger
		WebElement endPriceSlider = driver.findElement(By.xpath("(//div[@data-filter-type='slider']/div/a)[2]"));
		a.moveToElement(endPriceSlider).perform();
		a.dragAndDropBy(endPriceSlider, -10,0).perform();
		//9.Filter with color Navy
		a.moveToElement(driver.findElement(By.xpath("(//input[@id='Color_s-Navy'])/parent::div"))).perform();
		driver.findElement(By.xpath("(//input[@id='Color_s-Navy'])/parent::div")).click();
		//10 verify the all applied filters 
		String priceFilter = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		System.out.println("Applied price filter range "+priceFilter);
		
		String colorFilter = driver.findElement(By.xpath("(//a[@data-key='Color_s|Color'])[1]")).getText();
		System.out.println("colorFilter "+colorFilter);
		if(colorFilter.equalsIgnoreCase("Navy")) {
			System.out.println("Color filter applied");
		}
		//11. Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("(//div[@class='product-tuple-image ']/a)[1]"));
		a.moveToElement(firstResult).perform();
		//12. click QuickView button
		driver.findElement(By.xpath("((//div[@class='product-tuple-image ']/a)/following-sibling::div/div)[1]")).click();
		//13. Print the cost and the discount percentage
		List<WebElement> priceDetails = driver.findElements(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span"));
		System.out.println("Price Details : ");
		for(int i =0; i < priceDetails.size();i++) {
			String data = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span["+(i+1)+"]")).getText();
			System.out.println(data);
		}
		//14. Take the snapshot of the shoes.
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File path = new File("./screenshots/snapDeal.jpeg");
		FileUtils.copyFile(screenshot, path);
		//15. Close the current window
		driver.close();
		//16. Close the main window
		driver.quit();

	}

}
