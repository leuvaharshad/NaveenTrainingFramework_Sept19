package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {

	WebDriver driver;
	Properties prop;

	/**
	 * This method return the driver based on the browser name
	 * 
	 * @param browsername
	 * @return driver
	 * @throws InterruptedException 
	 */

	public WebDriver init_driver(String browsername) throws InterruptedException {
		if (browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			Thread.sleep(5000);
			driver = new ChromeDriver();
		} else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid browser name");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		return driver;

	}

	/**
	 * This method is for to read properties from config.properties
	 * 
	 * @return prop
	 */

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Harsh\\eclipse-workspace\\NaveenTrainingFramework-5thSeptBatch\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				System.out.println("File not loaded");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Config file path is invalid");
			e.printStackTrace();
		}
		return prop;
	}

}
