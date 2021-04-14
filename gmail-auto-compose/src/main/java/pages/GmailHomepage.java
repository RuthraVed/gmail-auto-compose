package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GmailHomepage {

	public int TimeoutValue = 30;

	public GmailHomepage(WebDriver driver) { 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	//Search compose button
	@FindBy(xpath = "//div[@role='button' and text()='Compose']")
	public WebElement composeButton;

	//Method to click compose button
	public void composeButtonClick() {
		composeButton.click();
	}

	//Search the To: field in email compose box
	@FindBy(name = "to")
	public WebElement toEmailTexbox;

	//Method to input receiver's emailId in the To: of email compose box
	public void toEmailTexboxInput(String receiverEmail) {
		toEmailTexbox.clear();
		toEmailTexbox.sendKeys(receiverEmail);
	}

	//Search the Subject: field in email compose box
	@FindBy(name = "subjectbox")
	public WebElement subjectTextbox;

	//Method to input subject in the Subject: of email compose box
	public void subjectTexboxInput(String subject) {
		subjectTextbox.clear();
		subjectTextbox.sendKeys(subject);
	}

	//Search the Body: field in email compose box
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	public WebElement bodyTexbox;

	//Method to input content in the Body: of email compose box
	public void bodyTexboxInput(String body) {
		bodyTexbox.clear();
		bodyTexbox.sendKeys(body);
	}

	//Search the send button in email compose box
	@FindBy(xpath = "//div[@role='button' and text()='Send']")
	public WebElement sendButton;

	//Method to click the send button of drafted email
	public void sendButtonClick() {
		sendButton.click();
	}
}
