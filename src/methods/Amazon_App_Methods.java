package methods;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import UserInterfaceElements.HomeScreenUI;
import UserInterfaceElements.NavigationDrawerScreenUI;
import UserInterfaceElements.WelcomeScreenUI;

public class Amazon_App_Methods {

	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileInputStream fis;

	public static void loginToApp(WebDriver driver, String path, String expectedUserName)
			throws InterruptedException, SQLException, IOException {

		Thread.sleep(10000);
		WelcomeScreenUI.signInButton(driver).click();
		Thread.sleep(1000);

		File src = new File(path);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		XSSFRow row = sheet.getRow(1);
		XSSFCell userName = row.getCell(0);

		XSSFRow row1 = sheet.getRow(1);
		XSSFCell password = row1.getCell(1);

		// Enter registered mobile number or email
		WelcomeScreenUI.emailTextfield(driver).sendKeys(NumberToTextConverter.toText(userName.getNumericCellValue()));

		WelcomeScreenUI.continueButton(driver).click();

		WelcomeScreenUI.passwordTextfield(driver).sendKeys(password.getStringCellValue());
		Thread.sleep(500);

		WelcomeScreenUI.loginButton(driver).click();
		Thread.sleep(1000);

		NavigationDrawerScreenUI.NavigatioDrawerMenuButton(driver).click();
		Thread.sleep(1000);

		
	}
	
	public static void searchAProduct(WebDriver driver, String productName) throws InterruptedException {
		
		NavigationDrawerScreenUI.homeMenu(driver).click();
		Thread.sleep(1000);
		HomeScreenUI.searchTextfield(driver).click();
		Thread.sleep(1500);
		HomeScreenUI.searchTextfield(driver).sendKeys(productName);
		Thread.sleep(500);
		HomeScreenUI.getSearchSuggestionListItem(driver);
		Thread.sleep(1000);
		HomeScreenUI.getProductListItem(driver);
		
	}

}
