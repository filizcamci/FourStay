package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.AdvancedSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class AdvancedSearchStepDefs extends ParentStepDefs{
	AdvancedSearchPage advancedPage;
	@When("the user gets map api url")
	public void the_user_gets_map_api_url() {
		log.info("starting--> the_user_gets_map_api_url");
		advancedPage=new AdvancedSearchPage();
		log.info("getting window handle");
		String handle1=Driver.getDriver().getWindowHandle();
		log.info("switching window");
		
		//this is to stay in the new tab
		//BrowserUtils.switchToWindow(handle);
		for (String handle : Driver.getDriver().getWindowHandles()) {
		    if (!handle.equals(handle1))
		    {
		        Driver.getDriver().switchTo().window(handle);
		    }
		}
		//String mapParams = advancedPage.mapAPIurl.getAttribute("map-lazy-load-params");
		//String mapParams=advancedPage.map.getText();
		advancedPage.dropdownSelector();
		//String s=advancedPage.selections.getText();
		//System.out.println(s);
		//System.out.println("map parameters: "+mapParams);
		log.info("verifying request a stay is displayed");
		Assert.assertTrue(advancedPage.requestAStay.isDisplayed());
		
		log.info("ending--> the_user_gets_map_api_url");
		
	}

	@Then("user requests the text from map api")
	public void user_requests_the_text_from_map_api() {
	    
	}
}
