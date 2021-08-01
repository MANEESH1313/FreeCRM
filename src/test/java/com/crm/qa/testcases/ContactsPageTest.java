package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
	loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactspage = homepage.clickOnContactsPage();
	}	

	/*
	 * @Test public void verifyContactsLabelTest() { boolean flag =
	 * contactspage.verifyContactsLabel(); Assert.assertTrue(flag); }
	 * 
	 * @Test public void selectContactsTest() {
	 * contactspage.selectContactsByName("abc def"); }
	 */	
	@DataProvider
	public Object[][] getCRMTestData() {
		System.out.println("inside data provider");
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(dataProvider = "getCRMTestData")
	public void createNewContactTest(String firstName, String lastName) {		 
		System.out.println(firstName);
		System.out.println(lastName);
		contactspage.createNewContact(firstName, lastName);
	}
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}	
}
