package pagesObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparasonPage {

	private WebDriver driver;
	private By firstProductAccentField = By.xpath("//tbody[contains(@class,'product-table__group')]"
			+ "//tr//td[3][contains(@class, 'product-table__cell_accent')]");
	private By secondProductAccentField = By.xpath("//tbody[contains(@class,'product-table__group')]"
			+ "//tr//td[4][contains(@class, 'product-table__cell_accent')]");
	private By firstProductName = By
			.xpath("//th[3][@class='product-table__cell']" + "//span[@class='product-summary__caption']");
	private By secondProductName = By
			.xpath("//th[4][@class='product-table__cell']" + "//span[@class='product-summary__caption']");

	public ComparasonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private List<WebElement> getAccentField(By accentField) {
		return this.getDriver().findElements(accentField);
	}

	private int countAccentField(By accentField) {
		return getAccentField(accentField).size();
	}

	private String getProductName(By nameLocator) {
		return this.getDriver().findElement(nameLocator).getText();
	}

	public String ShowComparasonResult() {
		String result;
		int firstProductFields = countAccentField(firstProductAccentField);
		int secondProductFields = countAccentField(secondProductAccentField);
		String firstProduct = getProductName(firstProductName);
		String secondProduct = getProductName(secondProductName);
		if (firstProductFields > secondProductFields)
			result = firstProduct + " имеет приемущество перед " + secondProduct;
		else if (secondProductFields > firstProductFields)
			result = secondProduct + " имеет приемущество перед " + firstProduct;
		else
			result = "не один из товаров не имеет приемущество";
		return result;
	}

}
