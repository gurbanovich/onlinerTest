package testClasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testing.TestFactory;

/**
 * class contains algorithm of implementation of main test
 * 
 * @author User
 *
 */
public class ComparasonTest extends BaseTest {

	/**
	 * method contains test algorithm which includes transition to catalog page
	 * (catalog enter as a parameter), open lists of groups (computers enter as
	 * a parameter), choose category (accessories enter as a parameter) and
	 * transition to page with group with certain products (RAM enter as a
	 * parameter), open list of producers and choose the producer (Dell enter as
	 * a parameter), choose two products of the list and transition to
	 * comparison page, collections advantage parameters either of products,
	 * count advantage parameters and return conclusion to console in a string
	 * form
	 * 
	 * @param category
	 * @param groupOfProducts
	 * @param subgroupOfProducts
	 * @param products
	 * @param produser
	 */
	@Test
	@Parameters({ "category", "groupOfProducts", "subgroupOfProducts", "products", "produser" })
	public static void findAndCompareProducts( String category,  String groupOfProducts,
			 String subgroupOfProducts,  String products,  String produser) {
		String actual = null;
		String expected = "Dell 2x8GB DDR4 PC4-19200 [A8711887] has an advantage over Dell 8GB DDR3 PC3-12800 370-23455";
		TestFactory factory = new TestFactory(driver);
		factory.getCatalogPage(category);
		factory.getGoodsPage(groupOfProducts, subgroupOfProducts, products);
		factory.getComparasonPage(produser);
		actual = factory.compareProducts();
		assertEquals(actual, expected);
		// System.out.println(factory.compareProducts());
	}

}
