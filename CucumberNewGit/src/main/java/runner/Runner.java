package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.*;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.ExtentRep1;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\APITesting\\CucumberNew\\FNHW-14.feature", glue="stepdefinition",
plugin={"usage","com.cucumber.listener.ExtentCucumberFormatter:"})

//com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html

public class Runner {
	

	@BeforeClass
	public static void setup()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		 extentProperties.setReportPath("C:\\APITesting\\CucumberNew\\target\\ExtentReport\\rep"+timeStamp.replace(":","_").replace(".","_")+".html");
	
	}
	
	@AfterClass
	public static void writeExtentReport()
	{
	Reporter.loadXMLConfig(new File("C:/APITesting/CucumberNew/configs/extent-config.xml"));
	Reporter.assignAuthor("PavanS");
	Reporter.setSystemInfo("User Name", "PavanS");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
		
}
