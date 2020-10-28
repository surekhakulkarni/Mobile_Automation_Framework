package UserInterfaceElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationDrawerScreenUI {

	// private variables
	private static WebElement element = null;

	// Navigation Drawer Region Elements

	// Navigation drawer menu Button
	public static WebElement NavigatioDrawerMenuButton(WebDriver driver) {
		element = driver
				.findElement(By.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/action_bar_burger']"));
		return element;
	}

	// User text
	public static WebElement UserText(WebDriver driver) {
		element = driver
				.findElement(By.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/action_bar_view']"));
		return element;
	}

	// Navigation drawer Home menu
	public static WebElement homeMenu(WebDriver driver) {
		element = driver
				.findElement(By.xpath(".//*[@resource-id = 'com.amazon.mShop.android.shopping:id/web_home_shop_by_department_label']"));
		return element;
	}

}
