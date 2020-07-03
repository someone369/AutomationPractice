package com.atp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atp.qa.base.TestBaseSetup;
import com.atp.qa.utils.TestUtils;

public class MyAccountPage extends TestBaseSetup{
	
	@FindBy(xpath = "//a[@title='Return to Home']")
	WebElement homeButton;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement appLogo;
	
	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orders;
	
	@FindBy(xpath = "//h1[text()='Order history']")
	WebElement orderhystory;
	
	@FindBy(xpath = "//a[@title='Credit slips']")
	WebElement creditSlips;
	
	@FindBy(xpath = "//h1[contains(text(),'Credit slips')]")
	WebElement creditSlipsHeadder;
	
	
	public MyAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyMyAccountTitle(){
		return driver.getTitle();
	}
	
	public boolean clickOnHomeButton(){
		homeButton.click();
		boolean ststus = appLogo.isDisplayed();
		return ststus;
	}
	
	public OrderHystoryPage clickOnOrderHystory(){
		orders.click();
		TestUtils.VisibleElementwait(orderhystory);
		return new OrderHystoryPage();
	}
	
	public CreditSlipsPage clickOnCreditSlips(){
		creditSlips.click();
		TestUtils.VisibleElementwait(creditSlipsHeadder);
		return new CreditSlipsPage();
	}
}
