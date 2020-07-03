package com.atp.qa.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.pages.DataDRivenLogin;
import com.atp.qa.pages.MyAccountPage;
import com.atp.qa.utils.TestUtils;


public class DataDrivenLoginTest extends TestBaseSetup{
	
	public static String sheetname = "TestScripts";
	DataDRivenLogin ddlogin;
	MyAccountPage myaccount;
	public DataDrivenLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initilization();
		ddlogin = new DataDRivenLogin();
		
		
	}
	@DataProvider
	public Object[][] testData(){
		Object[][] data = TestUtils.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "testData")
	public void loginTest(String UserName, String PassWord){
		myaccount = ddlogin.login(UserName, PassWord);
	} 
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
