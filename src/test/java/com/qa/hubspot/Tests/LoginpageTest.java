package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.Loginpage;

public class LoginpageTest {

	WebDriver driver;
	Basepage basepage;
	Properties prop;
	Loginpage loginpage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		loginpage = new Loginpage(driver);

	}
	
	@Test
	public void doLoginTest() {
		loginpage.dologin(prop.getProperty("user"), prop.getProperty("password"));
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

}
