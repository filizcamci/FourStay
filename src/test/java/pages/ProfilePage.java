package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ProfilePage {
	public ProfilePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//div[@class='d-flex flex-row justify-content-around']//div[ @class='role-icon guest-icon']")
	public WebElement occupation;
	@FindBy(xpath = "//div[@class='d-flex flex-row justify-content-around']//div[ @class='role-icon guest-icon']")
	public WebElement phoneNumber;
	
}
