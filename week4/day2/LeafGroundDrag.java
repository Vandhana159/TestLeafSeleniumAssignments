package testLeafAssignments.week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundDrag {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Draggable
		WebElement dragElement = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		System.out.println("Initially "+dragElement.getLocation());
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragElement,100, 400).perform();
		System.out.println("After dragging "+dragElement.getLocation());
		
		//Drag to location
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		action.dragAndDrop(source, destination).perform();
		
		//Draggable Columns
		WebElement srcColumn = driver.findElement(By.xpath("(//tr/th)[1]"));//Name
		WebElement desColumn = driver.findElement(By.xpath("(//tr/th)[3]"));//Quantity
		action.dragAndDrop(srcColumn, desColumn).perform();
		String msg = driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText();
		System.out.println(msg);
		if(msg.equalsIgnoreCase("Columns reordered"))
			System.out.println("Columns: Drag and drop performed successfully");
		else
			System.out.println("Columns: Drag and drop failed");
		action.scrollToElement(driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']"))).perform();
		
		//Draggable Rows
		WebElement srcRow = driver.findElement(By.xpath("//table/tbody[@id='form:j_idt111_data']/tr[4]"));
		WebElement desRow = driver.findElement(By.xpath("//table/tbody[@id='form:j_idt111_data']/tr[1]"));
		action.dragAndDrop(srcRow, desRow).perform();
		String alertMsg = driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText();
		System.out.println(alertMsg);
		if(alertMsg.equalsIgnoreCase("Row moved"))
			System.out.println("Row: Drag and drop performed successfully");
		else
			System.out.println("Row: Drag and drop failed");
		
		//scroll down
		action.scrollToElement(driver.findElement(By.xpath("(//div[@class='card'])[4]"))).perform();
		
		//Resize Image 528 95
		WebElement image = driver.findElement(By.xpath("(//div[@class='card'])[4]/div/div[1]"));
		action.dragAndDropBy(image, 150, 7).perform();
		String imgAlert = driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText();
		System.out.println(imgAlert);
		if(imgAlert.equalsIgnoreCase("Image resized"))
			System.out.println("Image resized performed successfully");
		else
			System.out.println("Image resized performed failed");
		
		//scroll down
				action.scrollToElement(driver.findElement(By.xpath("//div[@class='layout-footer']"))).perform();
				
		//Progress Bar
		String startProgress = driver.findElement(By.xpath("//div[@role='progressbar']/div[2]")).getText().replace("%", "");
		System.out.println("Progress initial % "+startProgress);
		driver.findElement(By.xpath("//span[text()='Start']")).click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		String finalProgress = driver.findElement(By.xpath("//div[@role='progressbar']/div[2]")).getText().replace("%", "");
		System.out.println("Progress final % "+finalProgress);
		int start = Integer.parseInt(startProgress);
		int end = Integer.parseInt(finalProgress);
		if(start != end)
			System.out.println("Progress successful");
		else
			System.out.println("Progress failed");
		
		//Range Slider
		String startRange = driver.findElement(By.xpath("//input[@id='form:txt6']")).getAttribute("value");
		int s_startRange = Integer.parseInt(startRange);
		String endRange = driver.findElement(By.xpath("//input[@id='form:txt7']")).getAttribute("value");
		int s_endRange = Integer.parseInt(endRange);
		WebElement startSlider = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
		action.dragAndDropBy(startSlider, 50, 0).perform();
		WebElement endSlider = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[2]"));
		action.dragAndDropBy(endSlider, -20, 0).perform();
		String startRange1 = driver.findElement(By.xpath("//input[@id='form:txt6']")).getAttribute("value");
		int s_startRange1 = Integer.parseInt(startRange1);
		String endRange1 = driver.findElement(By.xpath("//input[@id='form:txt7']")).getAttribute("value");
		int s_endRange1 = Integer.parseInt(endRange1);
		if((s_startRange != s_startRange1) && (s_endRange != s_endRange1))
			System.out.println("Ranging Slider works as expected ");
		else
			System.out.println("Failed to change the slider range");
		
		driver.close();

	}

}
