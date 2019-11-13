package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.Contactspage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.Loginpage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.Excelutils;

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
		homepage = loginpage.dologin(prop.getProperty("user"), prop.getProperty("password"));
		contactspage = homepage.gotoContactspage();

	}

	@Test(priority = 1)
	public void verifyContactspageTitleTest() throws InterruptedException {
		String title = contactspage.verifyPageTitleTest();
		System.out.println("Contacts page title is : " + title);
		Assert.assertEquals(title,Constants.Contacspage_Title, "Contactspage title not matching");
		
	}
	
	@DataProvider
	public static Object[][] getContactsData() {
		Object data[][]=Excelutils.getTestData(Constants.Contacspage_sheet);
		return data;
	}

	@Test(priority = 2,dataProvider="getContactsData")
	public void createContactsTest(String eMail,String firstName,String lastName,String jobTitle) throws InterruptedException {

		contactspage.clickonCreateContract(eMail,firstName,lastName,jobTitle);
		
	

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
