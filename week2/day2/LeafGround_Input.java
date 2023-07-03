package testLeafAssignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround_Input {
public static void main(String[] args) throws InterruptedException {
	//Driver object
	ChromeDriver driver = new ChromeDriver();
	//Launch URL "http://leaftaps.com/opentaps/control/login"
	driver.get("https://www.leafground.com/input.xhtml");
	driver.manage().window().maximize();
	//1. Type your name
	driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[1]")).sendKeys("Vandhana");
	//2. Append Country to this City.
	driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[2]")).sendKeys("India");
	//3. Verify if text box is disabled
	boolean enabled = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[3]")).isEnabled();
	if(!enabled)
		System.out.println("TextBox is disabled");
	else
		System.out.println("TextBox is enabled");
	//4. Clear the typed text.
	String rdata = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[4]")).getText();
	driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[4]")).clear();
	String data = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[4]")).getText();
	System.out.println("Retrieved data is "+rdata);
	if(data.equals(""))
		System.out.println("Text box is cleared");
	else
		System.out.println("Text box is not cleared");
	//5. Retrieve the typed text.
	String text = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[5]")).getAttribute("value");
	System.out.println(text);
	//6. Type email and Tab. Confirm control moved to next element (Grandparent - GrandChild)
	driver.findElement(By.xpath("(//div[@class='card'])[1]//input[@placeholder='Your email and tab']")).sendKeys("vandhanaKrish@gmail.com");
	WebElement mailId = driver.findElement(By.xpath("(//div[@class='card'])[1]//input[@placeholder='Your email and tab']"));
	mailId.sendKeys(Keys.TAB);
	WebElement activeElement = driver.switchTo().activeElement();
	WebElement nextElement = driver.findElement(By.xpath("//div[@class='grid formgrid']//textarea"));
	if(activeElement.equals(nextElement))
		System.out.println("Successfully navigated to next element");
	else
		System.out.println("Navigation to next element failed");
	
	//7. Type about yourself
	driver.findElement(By.xpath("//div[@class='grid formgrid']//textarea")).sendKeys("I belong to selenium weekend batch so far 4 classes has completed");
	//8.Just Press Enter and confirm error message*
	driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
	String errorMessage = driver.findElement(By.xpath("//div[@id='j_idt106:thisform:j_idt110']//span[2]")).getText();
	if(errorMessage.equalsIgnoreCase("Age is mandatory"))
		System.out.println("Error message is displayed as expected ");
	else
		System.out.println("Failed to display error message when enter is pressed");
	//9.Click and Confirm Label Position Changes
	String cssValue = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getCssValue("top");
	System.out.println(cssValue);
	System.out.println("Position "+driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation());
	driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
	System.out.println(driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getCssValue("top"));
	System.out.println("Position "+driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation());
	//10. Type your name and choose the third option
	driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys("Vandhana");
	driver.findElement(By.xpath("//div[@id='j_idt106:auto-complete']/ul")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']/ul/li[3]")).click();
	//11.Type your DOB (mm/dd/yyyy) and confirm date chosen
	String dob = "09/15/1995";
	driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys(dob);
	String mm = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	String yyyy = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	String dd =driver.findElement(By.xpath("//a[@class=' ui-state-default ui-state-active']")).getText();
	String selected_date = mm.concat("/"+dd).concat("/"+yyyy);
	if(dob.equalsIgnoreCase(selected_date))
		System.out.println("Entered date is selected as expected");
	else
		System.out.println("Select date is different");
	//12.Type number and spin to confirm value changed
	int number = 55;
	driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/input")).sendKeys(Integer.toString(number));
	driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/a[1]")).click();
	String value = driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/input")).getAttribute("aria-valuenow");
	int value1 = Integer.parseInt(value);
	if((number+1) == value1)
		System.out.println("Entered value is incremented by 1");
	else
		System.out.println("Failed to incremented the value by 1");
	driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/a[2]")).click();
	String value2 = driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/input")).getAttribute("aria-valuenow");
	int value3 = Integer.parseInt(value2);
	if( number == value3)
		System.out.println("Entered value is decremented by 1");
	else
		System.out.println("Failed to decremented the value by 1");
	//Type random number (1-100) and confirm slider moves correctly
	String slider = "65";
	driver.findElement(By.xpath("//input[@id='j_idt106:slider']")).sendKeys(slider);
	String sliderRange = driver.findElement(By.xpath("//div[@id='j_idt106:j_idt120']/div")).getAttribute("style").replaceAll("width: ", "").replaceAll("%;", "");
	if(sliderRange.equalsIgnoreCase(slider))
		System.out.println("Slider working as expected ");
	else
		System.out.println("Slider range and entered values are different");
	
	//Click and Confirm Keyboard appears
	
	driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).sendKeys(Keys.ENTER);
	boolean displayed = driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isDisplayed();
	if(displayed)
		System.out.println("Keyboard is displayed");
	else
		System.out.println("Failed to display keyboard");
	//CustomToolbar 
	driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[1]")).click();
    boolean bold = driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[1]")).isEnabled();
    System.out.println("Bold button selected/not "+bold);
    if(bold)
    	System.out.println("Bold icon is clicked");
    else
    	System.out.println("Bold icon is not clicked");
    driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[3]")).click();
    boolean underline = driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[3]")).isEnabled();
    System.out.println("Bold button selected/not "+underline);
    if(underline)
    	System.out.println("underline icon is clicked");
    else
    	System.out.println("underline icon is not clicked");
    driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("isDisplayed()\r\n"
    		+ "The isDisplayed method in Selenium verifies if a certain element is present and displayed. If the element is displayed, "
    		+ "then the value returned is true. If not, then the value returned is false.");
	//Text Editor
	driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[1]")).click();
	String selectFont = driver.findElement(By.xpath("(//span[@class='ql-picker-options'][1]/span[2])[1]")).getAttribute("data-value");
	
	driver.findElement(By.xpath("(//span[@class='ql-picker-options'][1]/span[2])[1]")).click();
	Thread.sleep(3000);
	String selectedFont = driver.findElement(By.xpath("//span[@class='ql-picker-label ql-active']")).getAttribute("data-value");
	//System.out.println(selectedFont  + selectFont );
	if(selectedFont.equalsIgnoreCase(selectFont))
		System.out.println(selectedFont+" is selected");
	else
		System.out.println("Failed to select desired font name");
	driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("isDisplayed()\r\n"
    		+ "The isDisplayed method in Selenium verifies if a certain element is present and displayed. If the element is displayed, "
    		+ "then the value returned is true. If not, then the value returned is false.");
}
}
