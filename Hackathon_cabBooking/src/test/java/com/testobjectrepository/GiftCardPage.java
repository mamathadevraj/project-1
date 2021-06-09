package com.testobjectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GiftCardPage {
	
	//STORING LOCATORS IN BY VARIABLES
	public static By denomination=By.xpath("//*[@id='dropDownDenominationContainer']//input");
	public static By quantity=By.id("quantity");
	public static By msg=By.tagName("textarea");
	public static By deliveryDateToday=By.id("dateNow");
	public static By deliveryDateSendLater=By.id("dateLater");
	public static By senderName=By.xpath("//input[@ng-model='Input.senderName']");
	public static By senderEmail=By.xpath("//input[@ng-model='Input.senderEmail']");
	public static By senderAddressLine1=By.xpath("//input[@ng-model='Input.senderAddressline_1']");
	public static By senderLandmark=By.xpath("//input[@ng-model='Input.senderLine_2']");
	public static By senderPincode=By.xpath("//input[@ng-model='Input.senderPincode']");
	public static By senderPhone=By.xpath("//input[@ng-model='Input.senderMobileno']");
	public static By invalidEmail=By.xpath("//small[contains(text(),'Email')]");
	public static By receiverCheckBox=By.xpath("//*[@id='receiverForm']//span[1]/input");
	public static By receiverName=By.xpath("//input[@ng-model='Input.receiverName']");
	public static By receiverEmail=By.xpath("//input[@ng-model='Input.receiverEmail']");
	public static By receiverPhone=By.xpath("//input[@ng-model='Input.receiverMobileno']");
	public static By termsBtn=By.xpath("//input[@ng-model='Input.terms_checked']");
	public static By submitBtn=By.xpath("//input[@value='PAY NOW']");
	public static By eGiftCard=By.xpath("/html/body/section[1]/div/ul[1]/li[3]/div[2]/div/a[1]");
	public static By otp=By.xpath("//input[@ng-model='Input.otpPassword']");
	
	
	//FUNCTIONS TO ACCESS THE LOCATORS
	public static WebElement getDenomination(WebDriver driver)
	{
		return driver.findElement(denomination);
	}
	
	public static Select getQuantity(WebDriver driver)
	{
		return new Select(driver.findElement(quantity));
	}
	
	public static WebElement getMessage(WebDriver driver)
	{
		return driver.findElement(msg);
	}
	
	public static WebElement getSenderName(WebDriver driver)
	{
		return driver.findElement(senderName);
	}
	
	public static WebElement getSenderEmail(WebDriver driver)
	{
		return driver.findElement(senderEmail);
	}
	
	public static WebElement getSenderAddress(WebDriver driver)
	{
		return driver.findElement(senderAddressLine1);
	}
	
	public static WebElement getSenderLandmark(WebDriver driver)
	{
		return driver.findElement(senderLandmark);
	}
	
	public static WebElement getSenderPincode(WebDriver driver)
	{
		return driver.findElement(senderPincode);
	}
	
	public static WebElement getSenderPhone(WebDriver driver)
	{
		return driver.findElement(senderPhone);
	}
	
	public static WebElement getRecieverCheckbox(WebDriver driver)
	{
		return driver.findElement(receiverCheckBox);
	}
	
	public static WebElement getReceiverName(WebDriver driver)
	{
		return driver.findElement(receiverName);
	}
	
	public static WebElement getReceiverEmail(WebDriver driver)
	{
		return driver.findElement(receiverEmail);
	}
	
	public static WebElement getReceiverPhone(WebDriver driver)
	{
		return driver.findElement(receiverPhone);
	}
	
	public static WebElement getTerms(WebDriver driver)
	{
		return driver.findElement(termsBtn);
	}
	
	public static WebElement getSubmitBtn(WebDriver driver)
	{
		return driver.findElement(submitBtn);
	}
	
	public static List<WebElement> getInvalidEmail(WebDriver driver)
	{
		return driver.findElements(invalidEmail);
	}
	
	public static WebElement getOTPTextbox(WebDriver driver)
	{
		return driver.findElement(otp);
	}
	
	public static List<WebElement> getEGiftCard(WebDriver driver)
	{
		return driver.findElements(eGiftCard);
	}
	

	

}
