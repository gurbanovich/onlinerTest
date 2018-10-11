package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The class of manage and operations on page catalog.onliner.by
 * 
 * @author User
 *
 */
public class CatalogPage extends AbstractPage {

	/**
	 * The field contains xpath query with parameter to receive a link to page
	 * of certain group of products
	 */
	private final String productsLocator = "//span[@class = 'catalog-navigation-list__dropdown-title' and contains(text(), '%s')]/..";
	/**
	 * The field contains xpath query with parameter to receive a link on list
	 * of groups of products
	 */
	private final String groupsLocator = "//div[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]/..";
	/**
	 * The field contains xpath query with parameter to receive a link on
	 * categories of products
	 */
	private final String categoryLocator = "//span[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]/..";

	/**
	 * Create the instance of catalog page which contains instance of WebDriver
	 * as a parameter
	 * 
	 * @param driver
	 */
	public CatalogPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * method click to link for showing categories of groups which enter as a
	 * parameter
	 * 
	 * @param category
	 */
	public void showCategories(String category) {
		this.getDriver().findElement(By.xpath(String.format(categoryLocator, category))).click();
	}

	/**
	 * method click to link for showing groups of products which enter as a
	 * parameter
	 * 
	 * @param category
	 */
	public void showGroupsOfProducts(String category) {
		this.getDriver().findElement(By.xpath(String.format(groupsLocator, category))).click();
	}

	/**
	 * method click to link for transition to page of certain group of products
	 * which enter as a parameter
	 */
	@Override
	public void goToCategoryPage(String category) {
		this.getDriver().findElement(By.xpath(String.format(productsLocator, category))).click();
	}

}
