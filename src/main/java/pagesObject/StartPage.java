package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends AbstractPage {
	
	private final String categoryLocator = "//span[@class = 'b-main-navigation__text'][text()='%s']/..";
	
	public StartPage(WebDriver driver) {
		super(driver);
	}
	
    @Override
	public void goToCategoryPage(String category) {
		this.getDriver().findElement(By.xpath(String.format(categoryLocator, category))).click();
    }
	
}
