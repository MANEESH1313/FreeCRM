package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(css="#dashboard-toolbar > div.ui.header.item.mb5.light-black")
	WebElement contactsLabel;

	@FindBy(name="first_name")
	WebElement firstname;

	@FindBy(name="last_name")
	WebElement lastname;

	@FindBy(xpath="//button[@class='ui linkedin button']/i[@class='edit icon']")	
	WebElement newbtn;
	
	@FindBy(xpath="//button[@class='ui linkedin button']/i[@class='save icon']")
	WebElement savebtn;

	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td/*/input[@name = 'id']"));
	}
	
	public void createNewContact(String ftname, String ltname) {
		newbtn.click();
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		savebtn.click();
	}

}
