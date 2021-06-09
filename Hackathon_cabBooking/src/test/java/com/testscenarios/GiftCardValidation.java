package com.testscenarios;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testobjectfunction.GiftCardFunctions;
import com.testobjectfunction.HomePageFunctions;
import com.userdefinedlibraries.*;

public class GiftCardValidation {
	public static WebDriver driver;
	public static Properties prop = GetPropertiesFile.getPropertiesInstance();
	public static String browser;
	public static String[] data = new String[10];
	public static XSSFCell cell;
	public static String eGiftCard;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static int winCount;
	public static ExtentReports report;
	public static ExtentTest logger;

	@BeforeClass
	// OPENING THE BROWSER
	public void driverConfig() {
		browser = prop.getProperty("browser");

		driver = DriverSetup.driverInstantiate(browser);
		driver.get("https://www.makemytrip.com/gift-cards/");
		report = ExtentReportFile.getReportInstance();

	}

	//READ EXCEL FILE BASED ON SHEETNAME
	public static void readExcelFile(String sheetname) {

		try {
			ExcelReadWrite.readExcelData(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//CLICK ON MORE FROM THE NAV MENU
/*	@Test(priority = 0, groups = { "Smoke" })
	public static void clickMore() {
		logger = report.createTest("More Menu");
		HomePageFunctions.bodyClick(driver);
		logger.log(Status.INFO, "Clicking anywhere in the home page");
		HomePageFunctions.clickMoreButton(driver);
		logger.log(Status.INFO, "Click on More menu");
	}

	//SELECT GIFTCARD OPTION
	@Test(priority = 1, groups = { "Regression" })
	public static void setGiftCardPage() {
		logger = report.createTest("Gift Card");
		try {
			readExcelFile("giftcardsValid");
			HomePageFunctions.setBookingType(driver, ExcelReadWrite.data[0]);
			logger.log(Status.INFO, "Clicked on 'Giftcard' option");
		} catch (StaleElementReferenceException e) {

		}
		logger.log(Status.PASS, "Successfully clicked on gift card option");

	}*/

	//CLICK E-GIFTCARD 
	@Test(priority = 2, groups = { "Smoke" })
	public static void clickGiftCard() {
		logger = report.createTest("Buy E-Gift Cards");
		eGiftCard = prop.getProperty("eGiftCard");
		GiftCardFunctions.clickEGiftCard(driver, eGiftCard);
		logger.log(Status.INFO, "Clicked on 'Buy E-Gift card' option");
		logger.log(Status.PASS, "Successfully clicked on E-gift card Button");
	}

	//VERIFY THE TITLE OF THE PAGE
	@Test(priority = 3, groups = { "Regression" })
	public static void verifyTitle() {
		logger = report.createTest("Title verification of the page");
		try {
			String expectedTitle = HomePageFunctions.getTitle(driver);
			logger.log(Status.INFO, "Get page title");
			String actualTitle = "Gift Cards - Buy Gift Vouchers Online, Gift Vouchers | MakeMyTrip.com";
			Assert.assertEquals(expectedTitle, actualTitle);
			logger.log(Status.PASS, "Assertion Passed");

		} catch (Exception e) {
			FailReport.reportFail(e.getMessage());
		}

	}

	//SWITCH FROM HOMEPAGE TO GIFTCARD PAGE
	@Test(priority = 4, groups = { "Smoke" })
	public static void switchToGiftCard() {
		logger = report.createTest("Switching to new Tab");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		logger.log(Status.INFO, "Switch to new handle");
		driver.switchTo().window(tabs2.get(1));
		logger.log(Status.PASS, "control switched successfully");
	}

	//VALIDATE THE GIFTCARD FORM BASED ON VALID AND INVALID DATA
	@Test(priority = 5, groups = { "Regression", "Smoke" })
	public static void validateForm() {
		logger = report.createTest("Validating form values by giving wrong input");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		readExcelFile("giftcardsInvalid");
		setGiftCardValues();
		System.out.println("Error Message: "+GiftCardFunctions.getInvalidEmail(driver));
		ExcelReadWrite.excelWriteData("giftcardsInvalid", "PASS", GiftCardFunctions.getInvalidEmail(driver));
		logger.log(Status.PASS, "validate successful by providing invalid inputs ");
		driver.navigate().refresh();
		logger = report.createTest("Validating form values by giving correct input");
		readExcelFile("giftcardsValid");
		setGiftCardValues();
		ExcelReadWrite.excelWriteData("giftcardsValid", "PASS", "OTP textbox field enabled");
		logger.log(Status.PASS, "validate successful by providing valid inputs ");
	}

	//SET THE FORM VALUES OF GIFTCARD PAGE
	public static void setGiftCardValues() {
		logger = report.createTest("Entering datas into the form");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Sending the form values from excel");
		GiftCardFunctions.setDenomination(driver, ExcelReadWrite.data[1]);
		GiftCardFunctions.setQuantity(driver, ExcelReadWrite.data[2]);
		GiftCardFunctions.setMessage(driver, ExcelReadWrite.data[3]);
		GiftCardFunctions.setSenderName(driver, ExcelReadWrite.data[4]);
		GiftCardFunctions.setSenderEmail(driver, ExcelReadWrite.data[5]);
		GiftCardFunctions.setSenderAddress(driver, ExcelReadWrite.data[6]);
		GiftCardFunctions.setSenderLandmark(driver, ExcelReadWrite.data[7]);
		GiftCardFunctions.setSenderPincode(driver, ExcelReadWrite.data[8]);
		GiftCardFunctions.setSenderPhone(driver, ExcelReadWrite.data[9]);
		GiftCardFunctions.setReceiverCheckbox(driver);
		GiftCardFunctions.setTerms(driver);
		GiftCardFunctions.setSubmitBtn(driver);
		logger.log(Status.PASS, "Data send to form successfully ");
	}

	//CHECK RECEIVER DETAILS IS SAME AS SENDER'S OR NOT
	@Test(priority = 6, groups = { "Regression", "Smoke" })
	public static void validateReceiverDetails() {
		logger = report.createTest("Entering datas into the form");
		String receiverName = GiftCardFunctions.getReceiverNameValue(driver);
		logger.log(Status.INFO, "Sending value for reciever name");
		Assert.assertEquals(receiverName, ExcelReadWrite.data[4]);
		logger.log(Status.PASS, "Reciever name Assertion Passed ");

		String receiverEmail = GiftCardFunctions.getReceiverEmailValue(driver);
		logger.log(Status.INFO, "Sending email value");
		Assert.assertEquals(receiverEmail, ExcelReadWrite.data[5]);
		logger.log(Status.PASS, "Reciever Email Assertion Passed ");

		String receiverPhone = GiftCardFunctions.getReceiverPhoneValue(driver);
		logger.log(Status.INFO, "Sending phone no");
		Assert.assertEquals(receiverPhone, ExcelReadWrite.data[9]);
		logger.log(Status.PASS, "Reciever phoneno Assertion Passed ");
	}

	//CLOSE THE DRIVER
	@AfterClass
	public static void tearDown() {
		driver.quit();
		report.flush();
	}

}
