package testLeafAssignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Done
public class LeafGround_RadioComponents {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/radio.xhtml");
	driver.manage().window().maximize();
	//Your most favorite browser
	driver.findElement(By.xpath("//table[@id='j_idt87:console1']//tr[1]/td[1]/div[1]/div[2]/span[1]")).click();
	//Find the default select radio button
	boolean defaultBrowser = false;
	for(int i = 1; i<5 ; i++)
	{
		defaultBrowser = driver.findElement(By.xpath("//table[@id='j_idt87:console2']/tbody/tr/td["+i+"]/div/div/input")).isSelected();
	if(defaultBrowser)
	{
		System.out.println("Selected browser "+driver.findElement(By.xpath("//table[@id='j_idt87:console2']/tbody/tr/td["+i+"]/label")).getText());
	}}
	//Select the age group (only if not selected)
	boolean ageGroup = false;
	for(int i = 1; i<4 ; i++)
	{
	 ageGroup = driver.findElement(By.xpath("(//div[@class='ui-g']/div["+i+"]/div/div/input)[2]")).isEnabled();
	}
	if(ageGroup)
	{
		System.out.println("Age is selected ");
	}
	else
		driver.findElement(By.xpath("(//div[@class='ui-g']/div[1]/div/div/input)[2]")).click();
	//Unselectable
	WebElement unselect =  driver.findElement(By.xpath("//div[@id='j_idt87:city2']/div/div[2]//div[2]"));
	unselect.click();
	String classAttribute = unselect.getAttribute("class");
	//System.out.println("classAttribute value "+classAttribute);
	if(classAttribute.contains("ui-state-active"))
		System.out.println("Radio button is selected once");
	else
		System.out.println("Radio button is not selected");
	unselect.click();
	String classAttribute1 = unselect.getAttribute("class");
	//System.out.println("classAttribute value "+classAttribute1);
	if(!classAttribute1.contains("ui-state-active"))
		System.out.println("Radio button is unselected");
	else
		System.out.println("Radio button is not unselected");
	driver.close();
}
}
