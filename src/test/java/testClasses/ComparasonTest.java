package testClasses;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testing.TestFactory;

public class ComparasonTest extends BaseTest {

	@Test
	@Parameters({ "category", "groupOfProducts", "subgroupOfProducts", "products", "produser" })
	public static void findAndCompareProducts(String category, String groupOfProducts, String subgroupOfProducts,
			String products, String produser) throws InterruptedException {
		TestFactory factory = new TestFactory(driver);
		factory.getCatalogPage(category);
		factory.getGoodsPage(groupOfProducts, subgroupOfProducts, products);
		factory.getComparasonPage(produser);
		System.out.println(factory.compareProducts());
	}

}
