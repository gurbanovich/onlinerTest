package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The class of manage and operations on main page onliner.by
 * 
 * @author User
 *
 */
public class StartPage extends AbstractPage {

	/**
	 * The field contains xpath query with parameter to receive a link to page
	 * of basic theme
	 */
	private final String categoryLocator = "//span[@class = 'b-main-navigation__text'][text()='%s']/..";

	/**
	 * Create the instance of main page which contains instance of WebDriver
	 * as a parameter
	 * @param driver
	 */
	public StartPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * method click to link for transition to page of basic theme which enter as
	 * a parameter
	 * 
	 * @param category
	 */
	@Override
	public void goToCategoryPage(String category) {
		this.getDriver().findElement(By.xpath(String.format(categoryLocator, category))).click();
	}

}
