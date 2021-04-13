package cucumber_stepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailAutoComposeStepDefinition {

	private WebDriver driver;
	private Properties properties = new Properties();
	
	
	@Before
	public void setUp(){
		try {
			properties.load(new FileReader(new File("src/test/resources/test.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ChromeOptions chromeOptions = new ChromeOptions();

		//Specifying the chrome data directory to use profiles
		try {
		chromeOptions.addArguments("user-data-dir=" + properties.getProperty("profilePath"));
		chromeOptions.addArguments("profile-directory=Profile 3");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
	}	

	@After
	public void tearDown(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@Given("user is already logged-in and on Gmail homepage")
	public void user_is_already_logged_in_and_on_gmail_homepage(){

		driver.get("https://mail.google.com/");		
	}

	@When("user clicks on the compose button")
	public void user_clicks_on_the_compose_button(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@role='button' and text()='Compose']")).click();
		
	}

	@And("user gives the recipients email address")
	public void user_gives_the_recipients_email_address(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("to")).sendKeys(properties.getProperty("email.recipient"));
		
	}

	@And("user gives the subject of email")
	public void user_gives_the_subject_of_email(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("subjectbox")).sendKeys(properties.getProperty("email.subject"));
		
	}

	@And("user writes in the body of email")
	public void user_writes_in_the_body_of_email(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(properties.getProperty("email.body"));

	}

	@Then("user clicks the send button")
	public void user_clicks_the_send_button(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@role='button' and text()='Send']")).click();
		
	}

}
