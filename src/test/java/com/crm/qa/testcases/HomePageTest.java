package com.crm.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
	loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}

	//@Test(retryAnalyzer = com.qa.analyzer.RetryAnalyzer.class)
	@Test
	public void verifyHomePageTitleTest()
	{
		String homepageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals("HomePage Title not matched",homepageTitle,"Cogmento CRM");
	}
	
	@Test
	public void verifyContactsLinkTest() {
		contactspage = homepage.clickOnContactsPage();
	}
	
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}	
}
