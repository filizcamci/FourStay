package step_definitions;



import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasicInfoPage;
import pages.HomePage;
import pages.MoreOptionsPage;
import pages.RolePage;
import pages.SignUpPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtils;

public class SignUpStepDefs {
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		
	}

	@When("the user enters valid email and password")
	public void the_user_enters_valid_email_and_password() throws Exception {
		ExcelUtils data = new ExcelUtils();
		List<List<String>> myData = data.getAllSheetData("users.xlsx", "data");
		int i=7;
		
		HomePage homePage=new HomePage();
		homePage.signUp.click();
		SignUpPage signUpPage=new SignUpPage();
		signUpPage.moreOptions.click();
		MoreOptionsPage moreOptionsPage=new MoreOptionsPage();
		moreOptionsPage.continueWEmail.click();
		BasicInfoPage basicInfoPage=new BasicInfoPage();
		basicInfoPage.firstName.sendKeys(myData.get(i).get(0));
		basicInfoPage.lastName.sendKeys(myData.get(i).get(1));
		basicInfoPage.email.sendKeys(myData.get(i).get(2));
		basicInfoPage.password.sendKeys(myData.get(i).get(3));
		basicInfoPage.signUp.click();
		BrowserUtils.waitFor(2);
		RolePage rolePage=new RolePage();
		rolePage.guest.click();
		rolePage.next.click();
	}

	@When("the user enters the phone number taken before")
	public void the_user_enters_the_phone_number_taken_before() {
	    
	}

	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String string) {
	    
	}

}
