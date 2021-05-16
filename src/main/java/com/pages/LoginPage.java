package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Encapsulation
	// 1. Private - By Locators and OR :
	private By userName = By.id("name");
	private By pwd = By.id("password");
	private By userMsg = By.id("msg1");
	private By pwdMsg = By.id("msg2");
	private By btnLogin = By.id("login");


	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. public - Page Actions

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUserName(String username) {
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(username);
	}

	public void enterPassword(String strpassword) {
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(strpassword);
	}

	public void clickOnLoginButton() {
		driver.findElement(btnLogin).click();
	}

	public String getUserMessage() {
		return driver.findElement(userMsg).getText();
	}

	public String getPasswordMessage() {
		return driver.findElement(pwdMsg).getText();
	}

	public void doLogin(String un, String pass) {
		System.out.println("Login with username:: " + un + " and password :: " + pass);
		enterUserName(un);
		enterPassword(pass);
		clickOnLoginButton();		
	}

}
