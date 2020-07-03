package com.atp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.utils.TestUtils;

public class LogInPage extends TestBaseSetup{
	
	
	//Page factory (or) Object repository
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitlogin;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement appLogo;
	
	
	// initilization of webelements
	
	public LogInPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyLogo(){
		return appLogo.isDisplayed();
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
