package pagesObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsPage extends AbstractPage {

	private By producersLocator = By.xpath("//div[@class = 'schema-filter__fieldset']//span[text() = 'Производитель']"
			+ "/../..//div[starts-with(text(),  'Все')]");
	private By comparasonLocator = By.xpath("//div[@id='schema-products']//span[@class = 'i-checkbox__faux']");
	private By ComparasonLink = By.xpath("//span[@data-bind = 'html: $root.text']"); 
	private final String produserLocator = "//span[@class = 'schema-filter__checkbox-text' and text() = '%s']";

	public GoodsPage(WebDriver driver) {
		super(driver);
	}

	public void showAllProducers() {
		this.getDriver().findElement(producersLocator).click();
	}

	public void setTwoComparasonGoods(String category) {
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 10, 5000);
		wait.until(ExpectedConditions.urlContains(category.toLowerCase()));
		List<WebElement> ex = this.getDriver().findElements(comparasonLocator);
		for (int i = 0; i <= 1; i++) {
			ex.get(i).click();
		}
	}

	public void goToComparasonPage() {
		this.getDriver().findElement(ComparasonLink).click();
	}

	@Override
	public void goToCategoryPage(String category) {
		this.getDriver().findElement(By.xpath(String.format(produserLocator, category))).click();
	}

}
