package com.automationpratice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilitymethods.Utility_Seleniummethods;

public class Registration_Login {

	
	Utility_Seleniummethods selenium = new Utility_Seleniummethods();
	
	public Registration_Login(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement login;
	@FindBy(xpath="//*[@id='email_create']")
	WebElement email;
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement submit;
	@FindBy(css="#id_gender1")
	WebElement gender ;
	@FindBy(css="#customer_firstname")
	WebElement customerFirstname ;
	@FindBy(css="#customer_lastname")
	WebElement customerLastname ;
	@FindBy(css="#passwd")
	WebElement password; 
	@FindBy(xpath="//*[@id='days']")
	WebElement days; 
	@FindBy(xpath="//*[@id='months']")
	WebElement months;
	@FindBy(xpath="//*[@id='years']")
	WebElement years;
	@FindBy(xpath="//input[@name='firstname']")
	WebElement add_firstname;
	@FindBy(xpath="//*[@name='lastname']")
	WebElement add_lastname;
	@FindBy(xpath="//*[@id='company']")
	WebElement comp_name;
	@FindBy(xpath="//*[@id='address1']")
	WebElement address; 
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	@FindBy(xpath="//*[@id='id_state']")
	WebElement state;
	@FindBy(xpath="//*[@id='postcode']")	
	WebElement pincode;
	@FindBy(css="#phone_mobile")
	WebElement mobileno;
	@FindBy(css="#alias")
	WebElement myaddress;
	@FindBy(css="#submitAccount")
	WebElement submitbutton;
	
	
	public boolean Loginpage (WebDriver driver) {
		
		selenium.click(login);
		selenium.setText("dummy50@gmail.com", email);
		selenium.click(submit);
		selenium.click(gender);
		selenium.setText("rupa", customerFirstname);
		selenium.setText("sree", customerLastname);
		selenium.setText("password@1", password);
		selenium.click(days);
		selenium.selectByIndex(days, 14);
		selenium.click(months);
		selenium.selectByIndex(months, 8);
		selenium.click(years);
		selenium.selectByIndex(years, 33);
		selenium.setText("RNB", customerFirstname);
		selenium.setText("CSI", add_lastname);
		selenium.setText("xyz", comp_name);
		selenium.setText("flot201,new chruch street", address);
		selenium.setText("Alameda", city);
		selenium.selectByVisibleText(state, "California");
		selenium.setText("20122", pincode);
		selenium.setText("+15106832134", mobileno);
		selenium.setText("myadress", myaddress);
		selenium.click(submitbutton);
		
		String title = driver.getTitle();
		return true;
		
	}
}
