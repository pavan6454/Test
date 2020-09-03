package managers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {
	WebDriver driver;
//	@Before
//	public void beforeHookfunction() throws Exception{
//
//	    Reporter.assignAuthor("PavansK");
//
//	         //BrowserStack();
//	       // SetDesiredCapabilities();
//	    }
//
//	    @After(order = 0)
//	    public void afterHookfunction() {
//	        System.out.println("test completed");
//	       
//			driver.quit();
//
//	    }

	    @After(order = 1)
	    public void afterScenario(Scenario scenario) {
	        if (scenario.isFailed()) {
	            String screenshotName = scenario.getName().replaceAll(" ", "_");
	            try {
	                //This takes a screenshot from the driver at save it to the specified location
	                //File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

	                TakesScreenshot scrShot =((TakesScreenshot)driver);
	                 File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);

	                //Building up the destination path for the screenshot to save
	                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	                File destinationPath = new File(System.getProperty("user.dir") + "/cucumber-reports/screenshots/" + screenshotName + ".png");

	                //Copy taken screenshot from source location to destination location
	                FileUtils.copyFile(sourcePath, destinationPath);   

	                //This attach the specified screenshot to the test
	                Reporter.addScreenCaptureFromPath(destinationPath.toString());
	            } catch (IOException e) {
	            } 
	        }
	    }

	}


