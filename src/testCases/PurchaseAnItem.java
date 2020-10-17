package testCases;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PurchaseAnItem {
	
	@SuppressWarnings("rawtypes")
	private static AndroidDriver driver;
	

	
	@BeforeMethod(alwaysRun = true)
	public void startAppium() throws Exception {

		// Set up desired capabilities and pass the Android app-activity
		// and app-package to Appium
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("deviceName", "520090c18edb467f");
		capabilities.setCapability("platformName", "Android");

		// This package name of app 
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");

		// This is Launcher activity of app 
		capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
		

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Amazon Shopping App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println("Session is created");
	}

}
