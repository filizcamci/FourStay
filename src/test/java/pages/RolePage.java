package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class RolePage {
	public RolePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//div[@class='d-flex flex-row justify-content-around']//div[ @class='role-icon guest-icon']")
	public WebElement guest;
	@FindBy(xpath = "//div[@class='form-wrapper']//div[ @class='role-icon host-icon']']")
	public WebElement host;
	@FindBy(className = "btn-primary")
	public WebElement next;
	
}
