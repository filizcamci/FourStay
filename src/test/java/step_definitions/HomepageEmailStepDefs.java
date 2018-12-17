package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class HomepageEmailStepDefs extends ParentStepDefs {
	HomePage homePage = new HomePage();

	@Given("the user is on fourstay home page")
	public void the_user_is_on_fourstay_home_page() {
		log.info("starting --> the_user_is_on_fourstay_home_page");
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		log.info("ending --> the_user_is_on_fourstay_home_page");
	}

	@When("the user clicks on the login link")
	public void the_user_clicks_on_the_login_link() {

		homePage.signIn.click();
	}

	@Then("the email field should be displayed")
	public void the_email_field_should_be_displayed() {
		assertTrue(homePage.email.isDisplayed());
	}

}
