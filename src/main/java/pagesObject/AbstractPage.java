package pagesObject;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
private WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	
	public abstract void goToCategoryPage(String category);

}
