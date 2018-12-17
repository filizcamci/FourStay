package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class MessageFramePage {

	public MessageFramePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(className = "intercom-messenger-body")
	public WebElement conversationBox;
	
	@FindBy(className = "intercom-launcher")
	public WebElement messaging;
}
