package QAPractice.FirstMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class firstTest {
	ExtentReports report;

	@BeforeTest
	public void configExtentReport() {
		String reportPath = System.getProperty("user.dir") + "\\extentreports\\index.html";
		report = new ExtentReports();
		ExtentSparkReporter configReport = new ExtentSparkReporter(reportPath);
		configReport.config().setDocumentTitle("Demo selenium reports");
		configReport.config().setReportName("Web automation");
		report.attachReporter(configReport);
		report.setSystemInfo("tester", "sharun");
	}

	@Test
	public void LaunchGoogleTest() {
		// TODO Auto-generated method stub
		ExtentTest test1 = report.createTest("Launch google test");
		System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Google"));
		//test1.fail("test failed - incorrect title");
		report.flush();
		driver.quit();
	}

}
