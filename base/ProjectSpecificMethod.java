package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcelData;

public class ProjectSpecificMethod {
	public RemoteWebDriver driver;
	public String fileName,sheetName;
	public static String leadId,firstName;
	@BeforeMethod
	 public void preCondition()
	 {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://leaftaps.com/opentaps/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	 @AfterMethod
	 public void postCondition() {
		 driver.close();
	 }
	 @DataProvider
	 public String[][] sendData() throws IOException{
		 return ReadExcelData.readData(fileName, sheetName);
	 }
}
