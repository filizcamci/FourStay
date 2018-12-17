package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(linkText = "LIST YOUR STAY")
	public WebElement listYourStay;

	@FindBy(linkText = "Already have an account? Login here!")
	public WebElement alreadyHaveAccount;

	@FindBy(xpath = "(//*[@class='title is-6'])[1]")
	public WebElement name;

	@FindBy(linkText = "Sign Up")
	public WebElement signUp;

	@FindBy(linkText = "Sign In")
	public WebElement signIn;

	@FindBy(id = "user_login")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement password;

	@FindBy(id = "btn-login")
	public WebElement loginBtn;

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;

	@FindBy(id = "rentoutto2")
	public WebElement endDate;

	@FindBy(id = "search")
	public WebElement search;

	@FindBy(id = "login")
	public WebElement login;
	
	
	

	public String selectCity(int num) {

		List<WebElement> cities = Driver.getDriver()
				.findElements(By.xpath("//*[@class='row justify-content-around mt-5']/div"));
		// System.out.println(cities.size());
		// System.out.println(cities.get(0).getText());
		Actions action = new Actions(Driver.getDriver());

		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// action.moveToElement(cities.get(num-1)).click().perform();
		BrowserUtils.waitFor(3);
		cities.get(num - 1).click();
		BrowserUtils.waitFor(2);
		return Driver.getDriver().getTitle();

	}

	public static void zoomIn() {
		// To zoom In page 4 time using CTRL and + keys.
		for (int i = 0; i < 1; i++) {
			Driver.getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		}
	}

	// this method returns:
	// 1.name of the city
	// 2.title of the new page
	public String[] selectCity(String cityName) {
		String[] values = new String[2];
		List<WebElement> cities = Driver.getDriver()
				.findElements(By.xpath("//*[@class='row justify-content-around mt-5']/div"));
		List<WebElement> cityNames = Driver.getDriver()
				.findElements(By.xpath("//*[@class='row justify-content-around mt-5']/div//h4"));
		// System.out.println(cities.get(0).getText());
		zoomIn();
		Actions action = new Actions(Driver.getDriver());

		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		BrowserUtils.waitFor(3);
		// System.out.println(cityNames.get(3).getText());
		for (int i = 0; i < cityNames.size(); i++) {
			if (cityNames.get(i).getText().contains(cityName.toUpperCase())) {
				values[0] = cityNames.get(i).getText();
				cities.get(i).click();
			}

		}
		values[1] = Driver.getDriver().getTitle();
		return values;
	}

	public void clickLink(int n) {
		List<WebElement> links = Driver.getDriver()
				.findElements(By.xpath("//*[@class='row mt-4 justify-content-between align-items-center pt-4']//a"));
		links.get(n - 1).click();
		BrowserUtils.waitFor(3);
		String handle1 = Driver.getDriver().getWindowHandle();
		// this is to stay in the new tab
		for (String handle : Driver.getDriver().getWindowHandles()) {
			if (!handle.equals(handle1)) {
				Driver.getDriver().switchTo().window(handle);
			}
		}

	}
}
