package managers;
import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;


public class ExtentRep1 {
	public static ExtentTest test;
	public static ExtentReports report;
	
	@After(order=0)
	public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            WebDriver driver=null;
			TakesScreenshot scrShot =((TakesScreenshot)driver);
            File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
            File destPath = new File("src/ScreenShots/" + System.currentTimeMillis()
            + ".png");
            FileUtils.copyFile(sourcePath, destPath);   
            Reporter.addScreenCaptureFromPath(destPath.toString());
        	}   
        }
//	public static String screenCapture(WebDriver driver) throws Exception {
//		test.log(LogStatus.FAIL,test.addScreenCapture(screenCapture(driver))+ "Test Failed");
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File Dest = new File("src/ScreenShots/" + System.currentTimeMillis()
//		+ ".png");
//		String errflpath = Dest.getAbsolutePath();
//		FileUtils.copyFile(scrFile, Dest);
//		return errflpath;
//		}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}