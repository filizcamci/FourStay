package step_definitions;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.BrowserUtils;
import utilities.Driver;

public class Hooks extends ParentStepDefs{
	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		// Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	

	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
			Color r=new Color(255,0,0);
			log.debug("!!!........THIS METHOD FAILS...........!!!");
			
		}
//		if(!scenario.isFailed())
//			log.info("SCENARIO PASSED");
		BrowserUtils.waitFor(3);
		Driver.closeDriver();
	}

}
