package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.AdvancedSearchPage;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class SearchInDifferentCitiesStepDefs extends ParentStepDefs{
	String title ;
	HomePage homePage=new HomePage();
	@When("user clicks on the city name he\\/she wants")
	public void user_clicks_on_the_city_name_he_she_wants() {
		log.info("starting --> user_clicks_on_the_city_name_he_she_wants");
	    
	    
	   // homePage.selectCity(2);
	    title = homePage.selectCity(2);
	    log.info("ending --> user_clicks_on_the_city_name_he_she_wants");
	}

	@Then("advanced search page opens")
	public void advanced_search_page_opens() {
		log.info("starting --> advanced_search_page_opens");
	   // String title=" Advanced search | Room rental, roommate finder, off-campus housing, homestay | 4stay";
	    //BrowserUtils.switchToWindow(title);
	    
	   // Driver.getDriver().switchTo().window(handle);
	    BrowserUtils.waitFor(2);
	    //Assert.assertTrue(Driver.getDriver().getTitle().contains("Advanced_search"));
	    Assert.assertEquals(title, Driver.getDriver().getTitle());
	    log.info("ending -->  advanced_search_page_opens");
	}
	@When("user clicks on the desired city name")
	public void user_clicks_on_the_desired_city_name() {
		log.info("starting--> user_clicks_on_the_desired_city_name");
		String expectedCityName="Baltimore";
		//System.out.println(expectedCityName);
		String[] values=homePage.selectCity(expectedCityName);
		String actualCityName=values[0];
		title=values[1];
		//System.out.println(actualCityName);
		Assert.assertEquals(expectedCityName.toUpperCase(),actualCityName);
		log.info("ending--> user_clicks_on_the_desired_city_name");
	}
	
	@Then("city name on the map matches the searched city name")
	public void city_name_on_the_map_matches_the_searched_city_name() {
		log.info("starting--> city_name_on_the_map_matches_the_searched_city_name");
		
		AdvancedSearchPage advencedSearchPage=new AdvancedSearchPage();
		System.out.println(advencedSearchPage.listView.getText());
		
		log.info("ending--> city_name_on_the_map_matches_the_searched_city_name");
	}
	
	@When("user clicks on {string}")
	public void user_clicks_on(String city) {
		log.info("starting--> user_clicks_on"+city);
		String[] values=homePage.selectCity(city);
		title=values[1];
		Assert.assertEquals(title, Driver.getDriver().getTitle());
		log.info("ending--> user_clicks_on"+city);
		
	}
	
	
}
