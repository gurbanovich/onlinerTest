package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * test class contains after and before methods
 * 
 * @author User
 *
 */
public class BaseTest {

	/**
	 * initialize static field by instance of Firefox web driver
	 */
	protected static WebDriver driver = new FirefoxDriver();

	/**
	 * method is performed before test and sets implicit wait for web driver and
	 * loads start web page onliner.by
	 */
	@BeforeMethod
	public static void loadDriver() {
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://onliner.by/");
	}

	/**
	 * method is performed after test and finishes web driver work
	 */
	@AfterMethod
	public void closeDriver() {
		if (driver != null)
			driver.quit();
	}

}
