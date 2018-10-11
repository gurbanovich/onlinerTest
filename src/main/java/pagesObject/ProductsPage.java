package pagesObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class of manage and operations on page of products catalog.onliner.by
 * 
 * @author User
 *
 */
public class ProductsPage extends AbstractPage {

	/**
	 * The field contains xpath query to receive a link for showing all
	 * producers of products
	 */
	private By producersLocator = By.xpath("//div[@class = 'schema-filter__fieldset']//span[text() = 'Производитель']"
			+ "/../..//div[starts-with(text(),  'Все')]");
	/**
	 * * The field contains xpath query to receive a link to flag of certain
	 * product
	 */
	private By comparasonLocator = By.xpath("//div[@id='schema-products']//span[@class = 'i-checkbox__faux']");
	/**
	 * * The field contains xpath query to receive a link to comparison page
	 */
	private By ComparasonLink = By.xpath("//span[@data-bind = 'html: $root.text']");
	/**
	 * The field contains xpath query with parameter to receive a link choose
	 * criterion of products
	 */
	private final String produserLocator = "//span[@class = 'schema-filter__checkbox-text' and text() = '%s']";

	/**
	 * Create the instance of products page which contains instance of WebDriver
	 * as a parameter
	 * 
	 * @param driver
	 */
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * method click to link for showing all producers of products
	 */
	public void showAllProducers() {
		this.getDriver().findElement(producersLocator).click();
	}

	/**
	 * method click to two flags of two products for its compare. Method
	 * contains a explicit wait for loading products according to choose
	 * criterion which enter as a parameter
	 * 
	 * @param category
	 */
	public void setTwoComparasonGoods(String category) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 10, 5000);
		wait.until(ExpectedConditions.urlContains(category.toLowerCase()));
		List<WebElement> ex = this.getDriver().findElements(comparasonLocator);
		for (int i = 0; i <= 1; i++) {
			ex.get(i).click();
		}
	}

	/**
	 * method click to link for transition to page of compare choosing products
	 */
	public void goToComparasonPage() {
		this.getDriver().findElement(ComparasonLink).click();
	}

	/**
	 * method click to link for choosing certain criterion of products which
	 * enter as a parameter
	 */
	@Override
	public void goToCategoryPage(String category) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 5, 500);
		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(produserLocator, category))));
		element.click();
	}

}
