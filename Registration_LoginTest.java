package com.automationpractice.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automationpratice.pages.AddToCart;
import com.automationpratice.pages.Registration_Login;

public class Registration_LoginTest {

	WebDriver driver;
	Registration_Login page ;
	
	@BeforeTest
	public void InvokeBrowser()	{
		
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver 80.0.3987.16\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		page = new Registration_Login (driver);
	}
	
	@Test
	public void Registration_Loginpage() {
		
		Assert.assertTrue(page.Loginpage(driver));
		
	}
}
