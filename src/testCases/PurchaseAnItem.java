package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import methods.Amazon_App_Methods;

public class PurchaseAnItem {
	
	
	private static WebDriver driver;
	ConfigFile config = new ConfigFile();
	
	
	XSSFWorkbook wb;
	static XSSFSheet sheet;
	FileInputStream fis;
	
	
	@BeforeTest
	public void g() throws IOException
	{
	File src = new File(config.getFilePath());
	fis = new FileInputStream(src);
	wb = new XSSFWorkbook(fis);
	sheet = wb.getSheetAt(0);
	}
	
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
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println("Session is created");
	}

	@Test
	public void purchaseAnItem() throws Exception
	{
		Amazon_App_Methods.loginToApp(driver,config.getFilePath(), config.getUserName());
		Amazon_App_Methods.searchAProduct(driver, "65-inch TV");
	}
	
	
	
	
	

}
