package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

public class Loginpage extends Basepage {

	WebDriver driver;
	ElementUtils elementUtils;

	// 1. create Webelemets of field
	By email = By.id("username");
	By password = By.id("password");
	By loginbtn = By.id("loginBtn");
	By noAccount = By.xpath("//div[@class='signup-link']/i18n-string");

	// 2.Create Constructor of page clase

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		elementUtils.waitForTitlePresent(Constants.Login_Page_Title, 15);
	}

	// 3.create basic function of login page

	public String getpageTitle() {

		String title = elementUtils.waitForTitlePresent(Constants.Login_Page_Title, 10);
		return title;
	}

	public boolean isAccountExist() {
		return elementUtils.isElementDisplayed(noAccount);
		// return driver.findElement(noAccount).isDisplayed();
	}

	public String verifyTextofNoAccountText() {
		return elementUtils.doGetText(noAccount);
		// return driver.findElement(noAccount).getText();
	}

	public Homepage dologin(String username, String pwd){

		elementUtils.doSendKeys(email, username);
		elementUtils.doSendKeys(password, pwd);
		elementUtils.doClick(loginbtn);
		elementUtils.waitForTitlePresent(Constants.Homepage_Title, 15);

		return new Homepage(driver);

	}

}
