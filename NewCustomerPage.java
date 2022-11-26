package com.banking.pageobjects;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	WebElement custName;

	@FindBy(css = "tbody tr:nth-child(5) td:nth-child(2) input")
	List<WebElement> genderButtons;

	@FindBy(css = "input[type='date']")
	WebElement dob;

	@FindBy(css = "textarea[name='addr']")
	WebElement addressOne;

	@FindBy(css = "input[name='city']")
	WebElement city;

	@FindBy(css = "input[name='state']")
	WebElement state;

	@FindBy(css = "input[name='pinno']")
	WebElement pinCode;

	@FindBy(css = "input[name='telephoneno']")
	WebElement phoneNum;

	@FindBy(css = "input[name='emailid']")
	WebElement emailID;

	@FindBy(xpath = "//input[@type='password']")
	WebElement setPassword;

	@FindBy(css = "input[type='submit']")
	WebElement submit;

	@FindBy(css = "input[type='reset']")
	WebElement resetButton;

	// dob format- ddmmyyyy
	public void customerNameGenderDob(String name, String gender, String birthDate) {
		custName.sendKeys(name);
		WebElement selectGender = genderButtons.stream().filter(e -> e.getAttribute("value").equalsIgnoreCase(gender))
				.findFirst().orElse(null);
		selectGender.click();
		dob.sendKeys(birthDate);
	}

	public void enterAddress(String line1, String custCity, String custState, String zipCode) {
		addressOne.sendKeys(line1);
		city.sendKeys(custCity);
		state.sendKeys(custState);
		pinCode.sendKeys(zipCode);
	}

	public void contactDetails(String phoneNumber, String email) {
		phoneNum.sendKeys(phoneNumber);
		emailID.sendKeys(email);
	}

	public void setAccountPassword(String password) {
		setPassword.sendKeys(password);
		submit.click();
	}

	public void resetCustomerDetails() {
		resetButton.click();
	}

}
