package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Asst_StepDefinition {
	public ChromeDriver driver;
	String leadID, leadID1, companyName;
	Set<String> allWindows;
	List<String> allhandles;

	Set<String> allWindows2;
	List<String> allhandles2;

	@Given("Open new Chrome browser")

	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@And("Load Application URL")
	public void loadURL() {
		driver.get("http://leaftaps.com/opentaps/");
	}

	@And("Enter the Username as {string}")
	public void enterusername(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@And("Enter the Password as {string}")
	public void enterpassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Given("Click on CRMSFA link")
	public void clickLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on Leads button")
	public void clickLeadLink() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on CreateLead link")
	public void clickCreateLeadLink() {

		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Enter the companyName as {string}")
	public void enterCompanyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}

	@And("Enter the firstName as {string}")
	public void enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@And("Enter the lastName as {string}")
	public void enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@When("click Submit button")
	public void clickCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("ViewLead should  be dislayed")
	public void createLeadExpectedResult() {

		boolean displayed = driver.findElement(By.xpath("//div[text()='View Lead']")).isDisplayed();

		if (displayed) {
			System.out.println("Lead Created Successfully");
		}

		else {
			System.out.println("Lead Not Created Successfully");
		}

		driver.close();

	}

	@But("ErrorMessage should display")
	public void errorMessage() {

		boolean displayed2 = driver.findElement(By.id("errorDiv")).isDisplayed();

		if (displayed2) {

			System.out.println("ErrorMessage is Displayed");

		}

		else {
			System.out.println("ErrorMessage is not Displayed");
		}

		driver.close();
	}

	@And("Click on FindLeads link")
	public void findLeads() {

		driver.findElement(By.linkText("Find Leads")).click();

	}

	@And("Click on phoneNumber tab")
	public void clickphNumbertab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@And("Enter PhoneNumber as {string}")
	public void enterphNumber(String phNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNumber);
	}

	@And("Click on FindLeads button")
	public void findLeadsButton() throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@And("Click on FirstLead")
	public void firstLead() {

		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@And("Click on Delete button")
	public void deleteButton() {
		driver.findElement(By.linkText("Delete")).click();

	}

	@And("Click on FindLeads link again")
	public void findLeads1() {

		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Enter the FirstLead ID")
	public void enterfirstLead() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}

	@And("Click on FindLeads button again")
	public void findLeadsButton1() {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Verify Deleted record is available")
	public void deleteLeadExpectedResult() {

		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

		driver.close();
	}

	@And("Click on MergeLeads link")
	public void mergeLeads() {

		driver.findElement(By.linkText("Merge Leads")).click();
	}

	@And("Click on FromLead widget")
	public void clickFromLeadWidget() {

		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@And("Enter From FirstName as {string}")
	public void FromFirstName(String FromFName) {

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FromFName);
	}

	@And("Click on FindLeads button for FromLead")
	public void FromFindLeadsButton() throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}

	@And("Click on First FromLead")
	public void FirstFromLead() {

		leadID1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
	}

	@And("Click on ToLead widget")
	public void ClickToLeadWidget() {

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}

	@And("Enter To FirstName as {string}")
	public void ToFirstName(String ToFName) {

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(ToFName);
	}

	@And("Click on FindLeads button for ToLead")
	public void ToFindLeadsButton() throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}

	@And("Click on First ToLead")
	public void FirstToLead() {

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}

	@When("Click on Merge button")
	public void MergeButton() {

		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}

	@Given("Click on FindLeads link after Merging")
	public void FindLeadsAfterMerge() {

		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Enter the From FirstLead ID")
	public void enterFromFirstLeadID() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID1);
	}

	@And("Click on FindLeads button for searching FirstLeadId")
	public void FindLeadsButtonAfterMerge() {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Verify Merged record is available")
	public void MergeExpectedResult() {

		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

		driver.close();

	}

	@And("Click on Edit button")
	public void editLead() {

		driver.findElement(By.linkText("Edit")).click();
	}

	@And("Update CompanyName as {string}")
	public void updateCompanyName(String comName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(comName);
		companyName = comName;
	}

	@And("Click on update button")
	public void clickUpdate() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify Updated record is available")
	public void EditExpectedResult() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(companyName)) {
			System.out.println("The Lead is updated successfully");
		} else {
			System.out.println("The Lead is not updated successfully");
		}

		driver.close();

	}

	@And("Click on Duplicate Lead button")
	public void clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}

	@And("Click on CreateLead button")
	public void clickCreateLeadButton1() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify Lead is created")
	public void DuplicateExpectedResult() {

		boolean displayed = driver.findElement(By.xpath("//div[text()='View Lead']")).isDisplayed();

		if (displayed) {
			System.out.println("Lead Duplicated Successfully");
		}

		else {
			System.out.println("Lead Not Duplicated Successfully");
		}

		driver.close();
	}
}
