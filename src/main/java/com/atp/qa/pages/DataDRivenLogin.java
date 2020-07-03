package com.atp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.utils.TestUtils;

public class DataDRivenLogin extends TestBaseSetup{
		
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitlogin;
	
	public DataDRivenLogin(){
		PageFactory.initElements(driver, this);
	}
	
	public MyAccountPage login(String unm, String pwd){
		TestUtils.ClickableElementwait(signin);
		signin.click();
		TestUtils.ClickableElementwait(submitlogin);
		username.sendKeys(unm);
		password.sendKeys(pwd);
		submitlogin.click();
		return new MyAccountPage();
	}
}
