package com.atp.qa.Tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.pages.CreditSlipsPage;
import com.atp.qa.pages.LogInPage;
import com.atp.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBaseSetup{
	
	MyAccountPage myaccountpage;
	LogInPage loginpage;
	CreditSlipsPage creditsslipspage;
	public static Logger log =Logger.getLogger(MyAccountPageTest.class);
	public MyAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginpage = new LogInPage();
		myaccountpage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		myaccountpage = new MyAccountPage();
		creditsslipspage = new CreditSlipsPage();
		log.info("Before method initilization done");
	}
	
	@Test
	public void verifyMyaccountTitle(){
		String actialTitle = myaccountpage.verifyMyAccountTitle();
		Assert.assertEquals(actialTitle, "My account - My Store", "Home page title is not match");
		log.info("Title done");
	}
	@Test
	public void homepageButton(){
		boolean status = myaccountpage.clickOnHomeButton();
		Assert.assertTrue(status);
		log.info("Home button done");
	}
	
	@Test
	public void orderHystoryButton(){
		myaccountpage.clickOnOrderHystory();
	}
	
	@Test
	public CreditSlipsPage CredtSlipsButton(){
		creditsslipspage = myaccountpage.clickOnCreditSlips();
		log.info("Credit slips done");
		return creditsslipspage;
		
	}
	
	@AfterMethod
	public void testDown(){
		driver.close();
	}
}
