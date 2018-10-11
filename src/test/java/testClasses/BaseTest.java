package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected static WebDriver driver = new FirefoxDriver();

	@BeforeMethod
	public static void loadDriver() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://onliner.by/");
	}

	@AfterMethod
	public void cleseDriver() {
		if (driver != null)
			driver.quit();
	}

}
