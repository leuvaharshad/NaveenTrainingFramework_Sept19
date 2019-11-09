package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.Contactspage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.Loginpage;

public class ContactspageTest {

	WebDriver driver;
	Properties prop;
	Basepage basepage;
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;

	@BeforeTest
	public void setup() throws InterruptedException {
		basepage = new Basepage();
		prop = basepage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginpage = new Loginpage(driver);
		Thread.sleep(7000);
		homepage = loginpage.dologin(prop.getProperty("user"), prop.getProperty("password"));

		contactspage = homepage.gotoContactspage();

	}

	@Test(priority = 1)
	public void verifyContactspageTitleTest() throws InterruptedException {
		String title = contactspage.verifPageTitleTest();
		Assert.assertEquals(title, "Contacts", "Contactspage title not matching");
		System.out.println("Contacts page title is : " + title);
	}

	@Test(priority = 2)
	public void createContactsTest() throws InterruptedException {

		contactspage.clickonCreateContract();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
