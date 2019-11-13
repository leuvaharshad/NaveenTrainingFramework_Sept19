package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getElement(By locator) {
		WebElement element;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Exception occured in get element");
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	

	/**
	 * This method is used to click on Element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while clicking on element");
			System.out.println(e.getMessage());
		}
	}

	public void doActionClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("Some exception occured while clicking on element with Action class");
			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * This method is used to enter value in locator given
	 * @param locator
	 * @param value
	 */

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured while entering value....");
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionSendkeys(By locator,String value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		}
		catch(Exception e) {
			System.out.println("Some exception occure while entering value by action");
			System.out.println(e.getMessage());
		}

}
	/**
	 * This Method is used when there is wait for title of element presence
	 */

	public void WaitForElementPresent(By locator,int timeOut) {
		WebDriverWait wait= new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public String waitForTitlePresent(String title,int timeOut) {
		WebDriverWait wait= new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		
	}
	
	/**
	 * This method is used to get text of field
	 * @param locator
	 * @return text
	 */
	public String doGetText(By locator) {
		try {
		return getElement(locator).getText();	
		}
		catch(Exception e) {
			System.out.println("Exception occured while getting text");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * This method is check that element is displayed or not
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator) {
		try {
		getElement(locator).isDisplayed();
		return true;
		}
		
		catch(Exception e) {
			System.out.println("Exception occured while checking element availablity ");
			System.out.println(e.getMessage());
			return false;
		}
		
	}

}