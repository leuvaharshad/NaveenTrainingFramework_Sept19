package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.Loginpage;

public class LoginpageTest {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	Loginpage loginpage;

	@BeforeTest
	public void setup() throws InterruptedException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		loginpage = new Loginpage(driver);

	}
	
	@Test (priority=2)
	public void doLoginTest() throws InterruptedException {
		loginpage.dologin(prop.getProperty("user"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest() {
		String title=loginpage.getpageTitle();
		Assert.assertEquals(title, "HubSpot Login");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
