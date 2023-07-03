package testLeafAssignments.week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> noOfWindows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(noOfWindows);
		driver.switchTo().window(windowsList.get(1));
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Dashboard"))
			System.out.println("Navigated to new window");
		else
			System.out.println("Navigation failed");
		
		//Find the number of opened tabs
		driver.switchTo().window(windowsList.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println("No of opened tabs "+windows.size());
		
		//Close all windows except Primary
		driver.switchTo().window(windowsList.get(0));
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> multiWindows = driver.getWindowHandles();
		List<String> multiWindowsList = new LinkedList<String>(multiWindows);
		for (int i =1; i<multiWindowsList.size(); i++) {
			driver.switchTo().window(multiWindowsList.get(i));
			System.out.println(multiWindowsList.get(i)+" closed");
			driver.close();
		}
		//Wait for 2 new tabs to open
		driver.switchTo().window(windowsList.get(0));
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> delayWindow = driver.getWindowHandles();
		List<String> delayWindowList = new LinkedList<String>(delayWindow);
		for (int i =1; i<delayWindowList.size(); i++) {
			System.out.println("Delay opened windows "+delayWindowList.get(i));
		}
		//close all opened windows
		driver.quit();
	}

}
