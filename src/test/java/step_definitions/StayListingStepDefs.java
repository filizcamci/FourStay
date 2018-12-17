package step_definitions;


import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.*;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class StayListingStepDefs extends ParentStepDefs{
	
	
	//final static Logger log = Logger.getLogger(StayListingStepDefs.class);
	//final static Logger log = Logger.getLogger(StayListingStepDefs.class.getName());

//	public static void main(String[] args) {
//		log.debug("debug");
//		log.warn("warn");
//		log.error("error");
//	}
	@When("user clicks on list your stay button")
	public void user_clicks_on_list_your_stay_button() {
		
		log.info("starting --> user_clicks_on_list_your_stay_button");
		BrowserUtils.waitFor(2);
		homePage.listYourStay.click();
		log.info("ending --> user_clicks_on_list_your_stay_button");
		
	}

	@Then("sign-up\\/sign-in page opens")
	public void sign_up_sign_in_page_opens() {
		log.info("starting --> sign_up_sign_in_page_opens");
		String expectedTitle = "How to become a host";
		// Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
		log.info("asserting title");
		Assert.assertTrue("title does not contain how to become a host", Driver.getDriver().getTitle().contains(expectedTitle));
		log.info("ending --> sign_up_sign_in_page_opens");
	}

	@When("user clicks on login here link")
	public void user_clicks_on_login_here_link() {
		log.info("starting --> user_clicks_on_login_here_link");
		homePage.alreadyHaveAccount.click();
		log.info("ending --> user_clicks_on_login_here_link");
	}

	@Then("login pop-up opens")
	public void login_pop_up_opens() {
		log.info("starting --> login_pop_up_opens");
		Assert.assertTrue(homePage.email.isDisplayed());
		log.debug("this element is not desplayed: "+homePage.email);
		
		//gets the class of the error/exception
		log.info("ending --> login_pop_up_opens");
	}

}
