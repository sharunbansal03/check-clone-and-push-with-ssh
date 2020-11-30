package QAPractice.FirstMavenProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {
	private static Logger log = LogManager.getLogger(FramesTest.class);

	@Test
	public void switchFrameTest() {
		log.debug("Setting chrome driver",true);
		System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("Chrome driver initiated");
		driver.get("https://the-internet.herokuapp.com/");

		log.info("Navigated to internet-herokupp");
		// click 'nested frames' link
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
		try {
			driver.switchTo().frame("frame-top");
			driver.switchTo().frame("frame-middle");
			System.out.println(driver.findElement(By.id("content")).getText());
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			log.error("Could not switch between frames");
		}
		driver.quit();
	}
}