package com.qa.hubspot.pages;

import java.util.Properties;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

public class Homepage extends Basepage {

	WebDriver driver;
	ElementUtils elementutils;

	// 1. Page Webelement creation
	By sales_Dashbord = By.xpath("//h1[text()='Sales Dashboard']");
	By profilepic = By.xpath("//a[@id='account-menu']");
	By accountName = By.xpath("//div[text()='Harshad Leuva']");
	By primaryContacts = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By secondaryContacts = By.xpath("(//a[@id='nav-secondary-contacts']/div)[1]");

	/// 2.Constructor of Homepage

	public Homepage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		elementutils.waitForTitlePresent(Constants.Homepage_Title,20);
	}

	// 3.Function of Homepage

	public String verifyHomepageTitle() {
		return elementutils.waitForTitlePresent(Constants.Homepage_Title, 15);

	}

	public String verifySalesDahboardText() {
		return elementutils.doGetText(sales_Dashbord);
	}

	public String verifyAccountname() {

		elementutils.doClick(profilepic);
		elementutils.WaitForElementPresent(accountName, 15);		
		return elementutils.doGetText(accountName);

	}

	public Contactspage gotoContactspage() {
		elementutils.WaitForElementPresent(primaryContacts, 15);
		elementutils.doClick(primaryContacts);
		elementutils.WaitForElementPresent(secondaryContacts, 15);
		elementutils.doClick(secondaryContacts);
		
		return new Contactspage(driver);
	}
}
