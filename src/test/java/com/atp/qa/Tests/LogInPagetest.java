package com.atp.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.pages.LogInPage;
import com.atp.qa.pages.MyAccountPage;

public class LogInPagetest extends TestBaseSetup{
	
	LogInPage loginpage;
	MyAccountPage myaccount;
	
	
	public LogInPagetest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initilization();
		loginpage = new LogInPage();
	}
	
	@Test
	public void verifyTitle(){
		String actual = loginpage.verifyTitle();
		System.out.println("Actual title of the page is : "+actual);
		String expected = "My Store";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void logoVerifyTest(){
		boolean status = loginpage.verifyLogo();
		if(status==true){
			System.out.println("Logo verified");
		}else{
			System.out.println("Logo not verified");
		}
		Assert.assertTrue(status);
	}
	
	@Test
	public void loginTest(){
		myaccount = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
