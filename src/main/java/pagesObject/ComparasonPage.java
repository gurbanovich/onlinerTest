package pagesObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The class of manage and operations on comparison page catalog.onliner.by
 * 
 * @author User
 *
 */
public class ComparasonPage {

	private WebDriver driver;
	/**
	 * The field contains xpath query to receive a link of fields contain
	 * advantage parameters of first comparable product
	 */
	private By firstProductAccentField = By.xpath("//tbody[contains(@class,'product-table__group')]"
			+ "//tr//td[3][contains(@class, 'product-table__cell_accent')]");
	/**
	 * The field contains xpath query to receive a link of fields contain
	 * advantage parameters of second comparable product
	 */
	private By secondProductAccentField = By.xpath("//tbody[contains(@class,'product-table__group')]"
			+ "//tr//td[4][contains(@class, 'product-table__cell_accent')]");
	/**
	 * The field contains xpath query to receive a link of fields contain full
	 * name of first comparable product
	 */
	private By firstProductName = By
			.xpath("//th[3][@class='product-table__cell']" + "//span[@class='product-summary__caption']");
	/**
	 * The field contains xpath query to receive a link of fields contain full
	 * name of second comparable product
	 */
	private By secondProductName = By
			.xpath("//th[4][@class='product-table__cell']" + "//span[@class='product-summary__caption']");

	/**
	 * Create the instance of comparison page which contains instance of
	 * WebDriver as a parameter
	 * 
	 * @param driver
	 */
	public ComparasonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method collect fields with advantage parameters in the list. By instance
	 * of fields of advantage parameters as a parameter, List of fields as a
	 * return object
	 * 
	 * @param accentField - locator of advantage parameters field
	 * @return - list of fields
	 */
	private List<WebElement> getAccentField(By accentField) {
		return this.getDriver().findElements(accentField);
	}

	/**
	 * method count fields of advantage parameters and return its number. By
	 * instance of fields of advantage parameters as a parameter
	 * 
	 * @param accentField - c
	 * @return - number of fields
	 */
	private int countAccentField(By accentField) {
		return getAccentField(accentField).size();
	}

	/**
	 * method return full name of comparable product. By instance of fields of
	 * product name as a parameter
	 * 
	 * @param nameLocator - locator of name field
	 * @return - name of product
	 */
	private String getProductName(By nameLocator) {
		return this.getDriver().findElement(nameLocator).getText();
	}

	/**
	 * method compare numbers of fields of advantage parameters and return
	 * result of product advantage at a string form
	 * 
	 * @return - result of compare of products
	 */
	public String showComparasonResult() {
		String result;
		int firstProductFields = countAccentField(firstProductAccentField);
		int secondProductFields = countAccentField(secondProductAccentField);
		String firstProduct = getProductName(firstProductName);
		String secondProduct = getProductName(secondProductName);
		if (firstProductFields > secondProductFields)
			result = firstProduct + " has an advantage over " + secondProduct;
		else if (secondProductFields > firstProductFields)
			result = secondProduct + " has an advantage over " + firstProduct;
		else
			result = "neither of products has advantage";
		return result;
	}

}
