package testing;

import org.openqa.selenium.WebDriver;

import pagesObject.CatalogPage;
import pagesObject.ComparasonPage;
import pagesObject.GoodsPage;
import pagesObject.StartPage;

public class TestFactory {

	private WebDriver driver;
	
	public TestFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getCatalogPage(String param) {
		StartPage page = new StartPage(this.getDriver());
		page.goToCategoryPage(param);
	}
	
	public void getGoodsPage(String param0, String param1, String param2) {
		CatalogPage page = new CatalogPage(this.getDriver());
		page.showGroupSOfCategories(param0);
		page.showCategories(param1);
		page.goToCategoryPage(param2);
	}
	
	public void getComparasonPage(String param) throws InterruptedException {
		GoodsPage page = new GoodsPage(this.getDriver());
		page.showAllProducers();
		page.goToCategoryPage(param);
		page.setTwoComparasonGoods(param);
		page.goToComparasonPage();
	}
	
	public String compareProducts() {
		ComparasonPage page = new ComparasonPage(this.getDriver());
		return page.ShowComparasonResult();
	}
}
