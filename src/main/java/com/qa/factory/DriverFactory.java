package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private WebDriver driver;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private static WebDriverWait wait;

	public WebDriver init_driver(String browser) {
		System.out.println("Browser selected for execution :: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(getDriver(),10);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() { // for parallel execution threads have to be synchronized
		return tlDriver.get();
	}

}
