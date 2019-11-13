package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtils;

public class Contactspage extends Basepage {
	WebDriver driver;
	Actions action;
	ElementUtils elementutils;
	Homepage homepage;

	// 1. By Locators

	By createContactsbtn = By.xpath("//span[text()='Create contact']");
	By dialogeheader = By.xpath("//header[@class='private-modal__header uiDialogHeader']/div/h3");
	By email = By.xpath("//input[@data-field='email']");
	By fname = By.xpath("//input[@data-field='firstname']");
	By lname = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactbtnondialog = By.xpath("//div[text()='Create contact']");

	// 2. Constructor

	public Contactspage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);

	}

	// 3. Action

	public String verifyPageTitleTest() {
		return elementutils.waitForTitlePresent(Constants.Contacspage_Title, 15);

	}

	public void clickonCreateContract(String mail, String FN, String LN, String job) throws InterruptedException {
		action = new Actions(driver);
		
		Thread.sleep(6000);

		elementutils.WaitForElementPresent(createContactsbtn, 15);
		elementutils.doClick(createContactsbtn);

		elementutils.WaitForElementPresent(email, 15);
		elementutils.doSendKeys(email, mail);

		elementutils.WaitForElementPresent(fname, 10);
		elementutils.doSendKeys(fname, FN);

		elementutils.WaitForElementPresent(lname, 10);
		elementutils.doSendKeys(lname, LN);

		elementutils.WaitForElementPresent(jobTitle, 15);
		elementutils.doActionSendkeys(jobTitle, job);

		elementutils.WaitForElementPresent(createContactbtnondialog, 5);
		elementutils.doActionClick(createContactbtnondialog);
		
/*		homepage=new Homepage(driver);
		homepage.gotoContactspage();
		*/
	
		
	}
}
