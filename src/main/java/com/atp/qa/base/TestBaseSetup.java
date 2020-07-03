package com.atp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.atp.qa.TestData.WebEventListenr;
import com.atp.qa.utils.TestUtils;

public class TestBaseSetup {

	public static WebDriver driver;
	public static Properties prop;
	public EventFiringWebDriver e_driver;
	public WebEventListenr eventListner;
	
	public TestBaseSetup() {
		prop = new Properties();
		try {
			FileInputStream fin = new FileInputStream(TestUtils.getPath(TestUtils.propPath));
			prop.load(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	public  void initilization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		eventListner = new WebEventListenr();
		e_driver = new EventFiringWebDriver(driver);
		e_driver.register(eventListner);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
	}
	
	public void listnerslog(){
		
	}

}
