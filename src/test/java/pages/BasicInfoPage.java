package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class BasicInfoPage {
	public BasicInfoPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "first-name")
	public WebElement firstName;
	@FindBy(id = "last-name")
	public WebElement lastName;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(className = "btn-primary")
	public WebElement signUp;
	
}
