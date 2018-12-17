package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class MoreOptionsPage {
	public MoreOptionsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(className = "email-btn")
	public WebElement continueWEmail;
}
