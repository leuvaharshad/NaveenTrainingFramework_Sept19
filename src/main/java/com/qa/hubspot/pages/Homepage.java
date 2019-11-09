package com.qa.hubspot.pages;

import java.util.Properties;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;

public class Homepage extends Basepage{
	
	WebDriver driver;
	Properties prop;
	
	//1. Page Webelement creation
	By sales_Dashbord= By.xpath("//h1[text()='Sales Dashboard']");
	By profilepic =By.xpath("//a[@id='account-menu']");
	By accountName= By.xpath("//div[text()='Harshad Leuva']");
	By primaryContacts = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By secondaryContacts= By.xpath("(//a[@id='nav-secondary-contacts']/div)[1]");
	
	///2.Constructor of Homepage
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
	}
	
	// 3.Function of Homepage
	
	public String verifyHomepageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public String verifySalesDahboardText() {
		String text=driver.findElement(sales_Dashbord).getText();
		return text;
	}
	
	public String verifyAccountname() throws InterruptedException {
		driver.findElement(profilepic).click();
		Thread.sleep(3000);
		return driver.findElement(accountName).getText();
		
	}
	
	public Contactspage gotoContactspage() throws InterruptedException {
		driver.findElement(primaryContacts).click();
		Thread.sleep(2000);
		driver.findElement(secondaryContacts).click();
		return new Contactspage(driver);
	}
}
