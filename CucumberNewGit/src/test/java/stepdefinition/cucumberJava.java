package stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.BaseTest;

public class cucumberJava { 
	   WebDriver driver = null; 
		
	   @Given("^I have open the browser$") 
	   public void openBrowser() { 
		   System.setProperty("webdriver.chrome.driver","C:\\APITesting\\cucumber\\driver\\chromedriver.exe");
	      driver = new ChromeDriver(); 
	      driver.manage().window().maximize();
	   } 
		
	   @When("^I open website$") 
	   public void goToApp() { 
	      driver.get("https://www.guru99.com/postman-tutorial.html") ;
	   } 
	   
	   @And("^User enters UserName and Password$") 
	   public void check() { 
		   String home = "//span[.='Home']";
		  String h = driver.findElement(By.xpath(home)).getText();
		  Assert.assertEquals("Hom", h);
	      System.out.println("Text is expected and Pass");
	   } 
	   
	   @Then("^Login button should exits$") 
	   public void loginButton() { 
	       
	         System.out.println("Test 1 Pass"); 
	      
	      driver.close(); 
	   } 
	   
	   //scenario2
	   @Given("^User LogOut from the Application$") 
	   public void sc() { 
		   System.out.println("pass");
		   
	   } 
	   
	  
	   @When("^Message displayed LogOut Successfully$") 
	   public void sc2() { 
	      System.out.println("pass");
	   } 
	   
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
	                File destinationPath = new File(System.getProperty("user.dir") + "/cucumber-reports/screenshots/" 
	                +screenshotName+System.currentTimeMillis()+".png");

	                //Copy taken screenshot from source location to destination location
	               FileUtils.copyFile(sourcePath, destinationPath);   

	                //This attach the specified screenshot to the test
	                Reporter.addScreenCaptureFromPath(destinationPath.toString());
	            } catch (IOException e) {
	            } 
	        }
	    }
	}