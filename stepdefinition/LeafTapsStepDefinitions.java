package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeafTapsStepDefinitions {
	public RemoteWebDriver driver;
	public String leadId, name;
	 
	@Given("Launch the Web browser")
	public void launchBrowser() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	}
	@Given("Launch the leaftaps url")
	public void launchUrl() {
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Given("Enter username,password")
	public void enterUserName() {
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	@And("Click on Login button")
	public void clickLogin() {
	driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Navigated to second Login page")
	public void verifyNavigation() {
		System.out.println(driver.getTitle());
		if(driver.getCurrentUrl().contains("login"))
		{
			System.out.println("Navigated to second login page. Click on CRM/SFA link");
		}
		else
			System.out.println("Failed to login/Navigate to second login page. Try again later");	
	}
	
	@Given("Click on CRMSFA Link")
	public void click_on_crm_sfa_link() {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	}
	@Then("HomePage is displayed")
	public void verifyHomePage() {
		if(driver.getTitle().equalsIgnoreCase("My Home | opentaps CRM"))
		{
			System.out.println("Navigated to HomePage successfully");
		}
		else
			System.out.println("Failed to navigate to homepage. Try again later");	
	}
	
	@Given("Click Leads link")
	public void clickOnCreateLink()
	{
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
	}
	@Then("Leads page is displayed")
	public void verifyLeadsPage() {
		if(driver.getTitle().equalsIgnoreCase("My Leads | opentaps CRM"))
		{
			System.out.println("Navigated to my leads page successfully");
		}
		else
			System.out.println("Failed to navigate to my leads page.Try again later");	
	}
	@When("Click on Create Lead")
	public void clickOnCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Then("Navigated to create lead page")
	public void navigateToCreateLead() {
		System.out.println(driver.getTitle());
	}
	
	@Given("Enter CompanyName and FirstName and LastName and LocalFirstName and Department and Description and email")
	public void enterLeadDetails() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Maya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mayon");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("MayaKrish");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("987654321");
		driver.findElement(By.name("departmentName")).sendKeys("Testing-Selenium");
		driver.findElement(By.name("description")).sendKeys("Selenium May 27 Weekend batch");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mayaKrishh@gmail.com");
	}
	
	@Given("Select State as NewYork")
	public void selectState() {
		WebElement dropDown = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select sc =new Select(dropDown);	
	    sc.selectByVisibleText("New York");
	}
	
	@When("Click on Create button")
	public void clickOnCreate() {
		    driver.findElement(By.className("smallSubmit")).click();
	}
	
	@Then("Verify the title of the page")
	public void verifyTitle(){
	    System.out.println(driver.getTitle());
	}
	
	@Given("Close the browser")
	public void closeBrowser() {
	    driver.close();
	}	
	@Given("Click Find leads")
	public void clickFindLeads() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}
	@Given("Click on Phone")
	public void click_on_phone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("Enter phone number")
	public void enter_phone_number() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("987654321");
	}
	@Given("Capture lead ID of First Resulting lead")
	public void capture_lead_id_of_first_resulting_lead() {
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("Lead id "+leadId);
	}
	@Given("Click First Resulting lead")
	public void click_first_resulting_lead() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Given("Click on Delete")
	public void click_on_delete() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}
	@Given("Enter captured lead ID")
	public void enter_captured_lead_id() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
	}
	@Given("Verify message No records to display in the Lead List. This message confirms the successful deletion")
	public void verify_message_no_records_to_display_in_the_lead_list_this_message_confirms_the_successful_deletion() throws InterruptedException {
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(data);
		if(data.equalsIgnoreCase("No records to display"))
			System.out.println("Data deleted successfully");
		else
			System.out.println("Data deletion failed");
	}
	@Given("Enter first name")
	public void enter_first_name() {
		driver.findElement(By.xpath("(//span[text()='Advanced']/following::input)[2]")).sendKeys("Maya");
	}
	@Given("Verify title of the page")
	public void verify_title_of_the_page() {
		if(driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM"))
		{
			System.out.println("Selected lead datas is displayed");
		}
	}
	@Given("Click Edit")
	public void click_edit() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	@Given("Change the company name")
	public void change_the_company_name() {
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Amazon");
	}
	@Given("Click Update")
	public void click_update() {
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
	}
	@Given("Click Find leads button")
	public void click_find_leads_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}
	@Given("Confirm the changed name appears")
	public void confirm_the_changed_name_appears() {
		String companyName= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		//System.out.println("Amazon ("+leadId+")");
		if(companyName.equals("Amazon ("+leadId+")"))
			{
		System.out.println("Company name updated successfully");
			}
	}
	@Given("Click on Email tab")
	public void click_on_email_tab() {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}
	@Then("Enter Email")
	public void enter_email() {
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mayaKrishh@gmail.com");
	}
	@Then("Capture name of First Resulting lead")
	public void capture_name_of_first_resulting_lead() throws InterruptedException {
		Thread.sleep(3000);
		name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
		System.out.println("First displayed Name is "+name);
	}
	@Given("Click Duplicate Lead")
	public void click_duplicate_lead() {
		driver.findElement(By.xpath("//div/a[text()='Duplicate Lead']")).click();
	}
	@Given("Verify title as Duplicate Lead")
	public void verify_title_as_duplicate_lead() {
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		if(title.equalsIgnoreCase("Duplicate Lead | opentaps CRM"))
			System.out.println("Successful");
		else
			System.out.println("Failed");
	}
	@Then("Confirm the duplicated lead name is same as captured name")
	public void confirm_the_duplicated_lead_name_is_same_as_captured_name() {
		String duplicateName=driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println("Duplicate record First Name "+duplicateName);
		if(duplicateName.equals(name))
			System.out.println("Successfuly created duplicate lead");
		else
			System.out.println("Duplicate Lead failed");
		}
	@Then("Clear the CompanyName Field using .clear\\() and Enter new CompanyName")
	public void clear_the_company_name_field_using_clear_and_enter_new_company_name() {
		  driver.findElement(By.id("createLeadForm_companyName")).clear();
		    driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Wipro");
		   
	}
	@Then("Clear the FirstName Field using .clear\\() and Enter new FirstName")
	public void clear_the_first_name_field_using_clear_and_enter_new_first_name() {
		 driver.findElement(By.id("createLeadForm_firstName")).clear();
		    driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vaishnu");
		  
	}

}
