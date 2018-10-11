package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends AbstractPage {
	
	private final String productsLocator = "//span[@class = 'catalog-navigation-list__dropdown-title' and contains(text(), '%s')]/..";
	private final String branchLocator = "//div[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]/..";
	private final String generalLocator = "//span[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]/..";
	
	public CatalogPage(WebDriver driver) {
		super(driver);
	}
	
    public void showGroupSOfCategories(String category) {
		this.getDriver().findElement(By.xpath(String.format(generalLocator, category))).click();
	}
    
    public void showCategories(String category) {
		this.getDriver().findElement(By.xpath(String.format(branchLocator, category))).click();
	}
	
    @Override
	public void goToCategoryPage(String category) {
		this.getDriver().findElement(By.xpath(String.format(productsLocator, category))).click();
	}
	
}
