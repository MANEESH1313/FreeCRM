package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setup() {
		initialization();
	loginpage = new LoginPage();
	}

	@Test
	public void loginPageTitle() {
		//Free CRM #1 cloud software for any business large or small
	String title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);		
	}
		
	@Test
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod()
		public void teardown() {
			driver.quit();
		}
	}