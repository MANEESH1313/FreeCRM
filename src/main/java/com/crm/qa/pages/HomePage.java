package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[3]")
	WebElement contactslink;

	@FindBy(xpath="//*[@id=\"main-nav\"]/a[5]")
	WebElement dealslink;

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

		
	public ContactsPage clickOnContactsPage()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsPage()
	{
		contactslink.click();
		return new DealsPage();
	}

}
