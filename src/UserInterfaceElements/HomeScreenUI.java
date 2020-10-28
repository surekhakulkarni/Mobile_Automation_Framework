package UserInterfaceElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScreenUI {

	// private variables
	private static WebElement element = null;
	

	// Home Region Elements

	// Search Text field
	public static WebElement searchTextfield(WebDriver driver) {
		element = driver
				.findElement(By.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/rs_search_plate']"));
		return element;
	}

	// Search Suggestion list
	public static void getSearchSuggestionListItem(WebDriver driver) {
		List<WebElement> list = driver.findElements(By
				.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/iss_search_suggestions_list_view']"));
		list.get(0).click();
	}

	// Product Suggestion list
	public static void getProductListItem(WebDriver driver) {
		List<WebElement> list = driver.findElements(
				By.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/list_product_linear_layout']"));
		list.get(1).click();
	}

}
