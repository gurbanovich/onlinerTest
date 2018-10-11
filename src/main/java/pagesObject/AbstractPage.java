package pagesObject;

import org.openqa.selenium.WebDriver;
/**
 * The abstract class contains constructor, setters/getters 
 * and common methods for classes which perform operations with
 * web pages
 * @author User
 *
 */
public abstract class AbstractPage {
	
private WebDriver driver;
	
/**
 * Create the instance of some web page which contains instance of WebDriver
 * 
 * @param driver
 */
	public AbstractPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * method for transition to page of category
	 * 
	 * @param category
	 */
	public abstract void goToCategoryPage(String category);

}
