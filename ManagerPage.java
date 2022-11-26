package com.banking.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {

	WebDriver driver;

	public ManagerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".heading3")
	WebElement scrollHeading;

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newCustomerPageButton;
	
	@FindBy(xpath="//tbody//tr//td//table//tr")
	public List<WebElement> webTableData;

	public String getScrollHeading() {
		return scrollHeading.getText();
	}

	public NewCustomerPage navigateToNewCustomerPage() {
		newCustomerPageButton.click();
		return new NewCustomerPage(driver);
	}
	
	public void getNewCustomerDetails() {
		
	}
	
	

}
