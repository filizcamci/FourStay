package step_definitions;

import java.util.List;
import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.HomePage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AsSeenInStepDefs extends ParentStepDefs {
	@When("user clicks on Business Journal link")
	public void user_clicks_on_Business_Journal_link() {
		log.info("starting --> user_clicks_on_Business_Journal_link");
		homePage.clickLink(1);
		log.info("ending --> user_clicks_on_Business_Journal_link");
	}

	@Then("correct <website> opens")
	public void correct_website_opens(Map<String, String> websites) {
		log.info("starting --> correct_website_opens");
		String expectedURL = websites.get("website");
		assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
		log.info("ending --> correct_website_opens");
	}

	@When("user clicks on Forbes link")
	public void user_clicks_on_Forbes_link() {
		log.info("starting --> user_clicks_on_Forbes_link");
		homePage.clickLink(2);
		log.info("ending --> user_clicks_on_Forbes_link");
	}

	@When("user clicks on Bisnow link")
	public void user_clicks_on_Bisnow_link() {
		log.info("starting --> user_clicks_on_Bisnow_link");
		homePage.clickLink(3);
		log.info("starting --> user_clicks_on_Bisnow_link");
	}

	@When("user clicks on Study Usa link")
	public void user_clicks_on_Study_Usa_link() {
		log.info("starting --> user_clicks_on_Study_Usa_link");
		homePage.clickLink(4);
		log.info("ending --> user_clicks_on_Study_Usa_link");
	}

	@When("user clicks on Arl now link")
	public void user_clicks_on_Arl_now_link() {
		log.info("starting --> user_clicks_on_Arl_now_link");
		homePage.clickLink(5);
		log.info("ending --> user_clicks_on_Arl_now_link");
	}
	
	
	@When("user clicks on {int} of the {string} link")
	public void user_clicks_on_of_the_link(Integer index, String link) {
		log.info("starting --> user_clicks_on_of_the_link");
		homePage.clickLink(index);
		log.info("ending --> user_clicks_on_of_the_link");
	}

}
