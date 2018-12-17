package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SignUpPage {
	public SignUpPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(partialLinkText = "More options")
	public WebElement moreOptions;
}
