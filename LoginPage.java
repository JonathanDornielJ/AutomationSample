package com.banking.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='uid']")
	WebElement uName;

	@FindBy(name = "password")
	WebElement uPassword;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginButton;

	@FindBy(css = "input[name='btnReset']")
	WebElement resetButton;

	public void goToWebsite(String url) {
		driver.get(url);
	}

	public ManagerPage enterLoginDetails(String userName, String userPassword) {
		uName.sendKeys(userName);
		uPassword.sendKeys(userPassword);
		loginButton.click();
		return new ManagerPage(driver);
	}

	public void resetLoginDetails() {
		resetButton.click();
	}

}
