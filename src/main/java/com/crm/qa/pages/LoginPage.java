package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR
	@FindBy(linkText="LOG IN")
	WebElement mainlogin;
	
	@FindBy(name="email")
	WebElement username; 

	@FindBy(name="password")
	WebElement password; 
	
	@FindBy(xpath="//*[contains(@class,'ui fluid large blue submit button')]")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class='rd-navbar-brand']//a[@title='free crm home']")
	WebElement crmlogo;
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login (String un, String pwd) {
		mainlogin.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
}


