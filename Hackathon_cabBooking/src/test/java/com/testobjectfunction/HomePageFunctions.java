package com.testobjectfunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testobjectrepository.*;

public class HomePageFunctions {

	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	public static String[] arr;
	public static int i=0;

	//FUNCTIONS TO PERFORM OPERATION ON WEBELEMENTS IN HOME PAGE
	public static void setBookingType(WebDriver driver, String type) {
		try {
		for (WebElement a : HomePage.getBookingType(driver)) {

			if (a.getText().equalsIgnoreCase(type)) {
				System.out.println(a.getText());
				a.click();
			}
		}
		}catch(Exception e)
		{
			
		}
	}

	public static void setJourneyType(WebDriver driver, String type) {
		for (WebElement a : HomePage.getjourneyType(driver)) {

			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(a));
			if (a.getText().equalsIgnoreCase(type)) {
				System.out.println(a.getText());
				a.click();
			}
		}
	}

	public static void setSourceCity(WebDriver driver) {
	
		HomePage.getSourceCity(driver).click();
	}

	public static void setSourceCityTextbox(WebDriver driver, String value) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.sourceCityTxtBox));
		HomePage.getSourceCityTxtBox(driver).sendKeys(value);
	}

	public static void setAutosuggestionCity(WebDriver driver, String city) {
		try {

			for (WebElement a : HomePage.getAutoSuggestionList(driver)) {
				
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(a));
				if (a.getText().toLowerCase().contains(city.toLowerCase())) {
					System.out.println(a.getText());
					a.click();
				}
			}
		} catch (Exception e) {

		}

	}

	public static void setDestinationCity(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.getDestinationCity(driver)));
		HomePage.getDestinationCity(driver).click();
	}

	public static void setDestinationCityTextbox(WebDriver driver, String value) {
		setDestinationCity(driver);
		wait = new WebDriverWait(driver, 30);
		//
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.destinationCityTxtBox));
		HomePage.getDestinationCityTxtBox(driver).sendKeys(value);
	}

	public static void setDepartureDate(WebDriver driver, String date) {
		String day = date.substring(0, date.indexOf("/"));
		String month = date.substring(date.indexOf("/") + 1, date.lastIndexOf("/"));
		String year = date.substring(date.lastIndexOf("/") + 1);
		String mon_year = month + " " + year;
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.getDepartureDate(driver)));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]")).click();
		
		while (true) {
			String mon = HomePage.getMonthYear(driver).getText();
			
			if (mon.equalsIgnoreCase(mon_year)) {
				HomePage.getDay(driver, day).click();
				System.out.println("Matched ");
				break;
			} else
				HomePage.getForwardBtn(driver).click();
		}
	}

	public static void clickSearch(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.getSearchBtn(driver)));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", HomePage.getSearchBtn(driver));
		
	}

	public static void clickMoreButton(WebDriver driver) {
		HomePage.getMoreBtn(driver).click();
	}

	public static void setTime(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.getTime(driver)));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", HomePage.getTime(driver));
	}

	public static void setTimeList(WebDriver driver, String time) {
		try {
			for (WebElement a : HomePage.getTimeList(driver)) {
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(a));
				if (a.getText().equalsIgnoreCase(time)) {
					System.out.println(a.getText());
					a.click();
				}

			}
		} catch (Exception e) {

		}
	}

	public static void setRooms(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.getRooms(driver)));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", HomePage.getRooms(driver));
	}

	public static String[] getNoOfAdults(WebDriver driver) {
		arr = new String[HomePage.getAdults(driver).size()];
		for (WebElement a : HomePage.getAdults(driver)) {
			
			arr[i] = a.getText();
			i++;
		}
		return arr;
	}

	public static void bodyClick(WebDriver driver) {
		HomePage.getBody(driver).get(0).click();
	}
	
	public static String getTitle(WebDriver driver) {
		return (driver.getTitle());
	}
	
	public static String getCityError(WebDriver driver) {
		return HomePage.getCityError(driver).getText();
	}
	
	public static String getDestinationCityAfter(WebDriver driver) {
		return HomePage.getDestinationCityAfter(driver).getAttribute("value");
	}
}
