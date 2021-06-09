
package com.testobjectfunction;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testobjectrepository.GiftCardPage;

public class GiftCardFunctions {

	public static WebElement element;
	public static List<WebElement> list;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;

	//FUNCTIONS TO PERFORM OPERATION ON WEBELEMENTS IN GIFTCARD PAGE
	public static void clickEGiftCard(WebDriver driver, String value) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(GiftCardPage.eGiftCard));
		for (WebElement a : GiftCardPage.getEGiftCard(driver)) {

			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(a));
			if (a.getText().equalsIgnoreCase(value)) {
				System.out.println(a.getText());
				a.click();
				break;
			}
		}
	}

	public static void setDenomination(WebDriver driver, String value) {
		element = GiftCardPage.getDenomination(driver);
		element.sendKeys(value);
	}

	public static void setQuantity(WebDriver driver, String value) {
		Select qnty = GiftCardPage.getQuantity(driver);
		qnty.selectByVisibleText(value);
	}

	public static void setMessage(WebDriver driver, String value) {
		element = GiftCardPage.getMessage(driver);
		element.sendKeys(value);
	}

	public static void setSenderName(WebDriver driver, String value) {
		element = GiftCardPage.getSenderName(driver);
		element.sendKeys(value);
	}

	public static void setSenderEmail(WebDriver driver, String value) {
		element = GiftCardPage.getSenderEmail(driver);
		element.sendKeys(value);
	}

	public static void setSenderAddress(WebDriver driver, String value) {
		element = GiftCardPage.getSenderAddress(driver);
		element.sendKeys(value);
	}

	public static void setSenderLandmark(WebDriver driver, String value) {
		element = GiftCardPage.getSenderLandmark(driver);
		element.sendKeys(value);
	}

	public static void setSenderPincode(WebDriver driver, String value) {
		element = GiftCardPage.getSenderPincode(driver);
		element.sendKeys(value);
	}

	public static void setSenderPhone(WebDriver driver, String value) {
		element = GiftCardPage.getSenderPhone(driver);
		element.sendKeys(value);
	}

	public static void setReceiverCheckbox(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(GiftCardPage.getRecieverCheckbox(driver)));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", GiftCardPage.getRecieverCheckbox(driver));
	}

	public static String getReceiverNameValue(WebDriver driver) {
		element = GiftCardPage.getReceiverName(driver);
		return element.getAttribute("value");
	}

	public static String getReceiverEmailValue(WebDriver driver) {
		element = GiftCardPage.getReceiverEmail(driver);
		return element.getAttribute("value");
	}

	public static String getReceiverPhoneValue(WebDriver driver) {
		element = GiftCardPage.getReceiverPhone(driver);
		return element.getAttribute("value");
	}

	public static void setTerms(WebDriver driver) {
		element = GiftCardPage.getTerms(driver);
		wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(GiftCardPage.termsBtn));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", GiftCardPage.getTerms(driver));
	}

	public static void setSubmitBtn(WebDriver driver) {

		element = GiftCardPage.getSubmitBtn(driver);
		wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(GiftCardPage.submitBtn));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}

	public static String getInvalidEmail(WebDriver driver) {
		wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(GiftCardPage.invalidEmail));

		return GiftCardPage.getInvalidEmail(driver).get(0).getText();
	}

	public static boolean OTPTextbox(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(GiftCardPage.otp));
		if (GiftCardPage.getOTPTextbox(driver).isDisplayed())
			return true;
		return false;
	}
}
