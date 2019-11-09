package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.Basepage;

public class Contactspage extends Basepage {
	WebDriver driver;
	Actions action;
	
	
	//1. By Locators
	
	By createContactsbtn= By.xpath("//span[text()='Create contact']");
	By dialogeheader =By.xpath("//header[@class='private-modal__header uiDialogHeader']/div/h3");
	By email= By.xpath("//input[@data-field='email']");
	By fname =By.xpath("//input[@data-field='firstname']");
	By lname =By.xpath("//input[@data-field='lastname']");
	By jobTitle =By.xpath("//input[@data-field='jobtitle']");
	By createContactbtnondialog= By.xpath("//div[text()='Create contact']");
	
	//2. Constructor
	
	public Contactspage(WebDriver driver) {
		this.driver= driver;
		
	}

	// 3. Action
	
	public String verifPageTitleTest() throws InterruptedException {
		Thread.sleep(4000);
		String title=driver.getTitle();
		return title;
	}
	
	public void clickonCreateContract() throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(createContactsbtn).click();
		Thread.sleep(3000);
		driver.findElement(email).sendKeys("Test1@abc.com");
		driver.findElement(fname).sendKeys("Harshad");
		driver.findElement(lname).sendKeys("Leuva");
		Thread.sleep(3000);
		driver.findElement(jobTitle).sendKeys("QA Engineer");
		Thread.sleep(3000);
		//driver.findElement(createContactbtnondialog).click();
		WebElement createconclick=driver.findElement(createContactbtnondialog);
		action.click(createconclick).build().perform();
		
		
	}
}
