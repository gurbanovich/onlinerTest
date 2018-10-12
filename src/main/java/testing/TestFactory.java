package testing;

import org.openqa.selenium.WebDriver;

import pagesObject.CatalogPage;
import pagesObject.ComparasonPage;
import pagesObject.ProductsPage;
import pagesObject.StartPage;

/**
 * class of making up processes in every page
 * 
 * @author User
 *
 */
public class TestFactory {

	private WebDriver driver;

	/**
	 * Create the instance of Test factory which contains instance of WebDriver
	 * as a parameter
	 * 
	 * @param driver
	 */
	public TestFactory(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method startup sequence on the main page onliner.by, basic theme enter as
	 * a parameter
	 * 
	 * @param param - theme of next page
	 */
	public void getCatalogPage(String param) {
		StartPage page = new StartPage(this.getDriver());
		page.goToCategoryPage(param);
	}

	/**
	 * method startup sequence on the catalog page onliner.by, category of
	 * products, group of products and products enter as a parameter
	 * 
	 * @param param0 - category of products
	 * @param param1 - group of products
	 * @param param2 - product
	 */
	public void getGoodsPage(String param0, String param1, String param2) {
		CatalogPage page = new CatalogPage(this.getDriver());
		page.showCategories(param0);
		page.showGroupsOfProducts(param1);
		page.goToCategoryPage(param2);
	}

	/**
	 * method startup sequence on the products page onliner.by, name of producer
	 * enter as a parameter
	 * 
	 * @param param - name of producer
	 */
	public void getComparasonPage(String param) {
		ProductsPage page = new ProductsPage(this.getDriver());
		page.showAllProducers();
		page.goToCategoryPage(param);
		page.setTwoComparasonGoods(param);
		page.goToComparasonPage();
	}

	/**
	 * method startup sequence on the comparison page onliner.by and return
	 * result of product advantage at a string form
	 * 
	 * @return - result of compare of products
	 */
	public String compareProducts() {
		ComparasonPage page = new ComparasonPage(this.getDriver());
		return page.ShowComparasonResult();
	}
}
