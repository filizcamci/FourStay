package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdvancedSearchPage{

	
	public AdvancedSearchPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='col-md-12']/span")
	public WebElement listView;
	
	@FindBy(xpath = "//div[@id='map']/div/div")
	public WebElement mapAPIurl;
	
	@FindBy(xpath = "//div[@id='map']")
	public WebElement map;
	
	@FindBy(xpath = "//div[@class='content']/div[2]/div")
	public WebElement selections;
	
	@FindBy(linkText = "REQUEST A STAY")
	public WebElement requestAStay;
	
	public void dropdownSelector() {
		List<WebElement> selections=Driver.getDriver().findElements(By.xpath("//div[@class='content']/div[2]/div"));
		System.out.println("there are "+selections.size()+" selections");
		for(WebElement selection: selections)
			System.out.println(selection.getText());
	}
	
	
	//div[@class='form-group dropdown-inputs']/div
	//div[@class='dropdown-control room-type']
	//div[@class='content']/div[2]//span
}
