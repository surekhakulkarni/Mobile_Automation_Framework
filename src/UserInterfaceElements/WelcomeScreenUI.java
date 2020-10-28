package UserInterfaceElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class WelcomeScreenUI {

	// private variables
	private static WebElement  element = null;

	// Welcome Region Elements

	// Already a customer Sign In Button
	public static WebElement  signInButton(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@text = 'Already a customer? Sign in']"));
		return element;
	}

	// Mobile number or Email text field
	public static WebElement emailTextfield(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@resource-id='ap_email_login']"));
		return element;
	}
	

	// Continue Button
	public static WebElement continueButton(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@resource-id = 'continue']"));
		return element;
	}

	// Password text field

	public static WebElement passwordTextfield(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@resource-id = 'ap_password']"));
		return element;
	}

	// Login Button
	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@resource-id = 'signInSubmit']"));
		return element;
	}

}
