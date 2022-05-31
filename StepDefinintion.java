package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinintion {
public ChromeDriver driver;
	
	@Given("Open the Chrome Browser")
	public void open_the_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Given("Load the Application URL")
	public void load_the_application_url() {
	    driver.get("http://leaftaps.com/opentaps/");
	}
	@Given("Enter the Username as demosalesmanager")
	public void enter_the_username_as_demosalesmanager() {
	    driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}
	@Given("Enter the password as crmsfa")
	public void enter_the_password_as_crmsfa() {
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	@When("Click on the Login button")
	public void click_on_the_login_button() {
	    driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {
	 boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
	 if (displayed) {
		 System.out.println("Displayed");
	 }else {
		 System.out.println("Not Displayed");
	 }
	}
}
