package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;

public class Loginpage extends Basepage {
	
	WebDriver driver;
	
	//1. create Webelemets of field
	By email= By.id("username");
	By password = By.id("password");
	By loginbtn = By.id("loginBtn");
	
	//2.Create Constructor of page clase
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.create basic function of login page 
	
	public String getpageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public Homepage dologin(String username,String pwd) throws InterruptedException {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		Thread.sleep(5000);
		return new Homepage(driver);
		
	}
	

}
