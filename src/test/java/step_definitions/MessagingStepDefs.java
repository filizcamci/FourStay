package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MessageFramePage;
import utilities.BrowserUtils;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MessagingStepDefs extends ParentStepDefs {
	MessageFramePage messageFramePage = new MessageFramePage();
	@When("user clicks on message icon")
	public void user_clicks_on_message_icon() {
		log.info("starting --> user_clicks_on_message_icon");
		//assertTrue("messaging box is not displayed".toUpperCase(),homePage.messaging.isDisplayed());
		BrowserUtils.waitFor(2);
		Driver.getDriver().switchTo().frame("intercom-launcher-frame");
		messageFramePage.messaging.click();
		log.info("ending --> user_clicks_on_message_icon");
	}

	@Then("conversation box opens")
	public void conversation_box_opens() {
		log.info("starting --> conversation_box_opens");
		Driver.getDriver().switchTo().defaultContent();
		Driver.getDriver().switchTo().frame("intercom-messenger-frame");
		assertTrue(messageFramePage.conversationBox.isDisplayed());
		log.info("ending --> conversation_box_opens");
	}
}
