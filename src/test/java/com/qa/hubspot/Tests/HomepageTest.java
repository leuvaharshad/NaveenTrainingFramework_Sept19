package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.Loginpage;

public class HomepageTest {
	
	WebDriver driver;
	Basepage basepage;
	Properties prop;
	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basepage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		loginpage = new Loginpage(driver);
		
		try {
			homepage=loginpage.dologin(prop.getProperty("user"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			System.out.println("issue in login");
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String title=homepage.verifyHomepageTitle();
		Assert.assertEquals(title, "Account Setup | HubSpot","Homepage title notmaching");
	}
	
	@Test(priority=2)
	public void verifyAccountNameTitleTest() throws InterruptedException {
		String accountname=homepage.verifyAccountname();
		System.out.println("Account user name is "+accountname);
		
	}
	
	@Test(priority=3)
	public void  gotoContactspageTest() throws InterruptedException {
		homepage.gotoContactspage();
		System.out.println("Welcome to Contacts page");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
