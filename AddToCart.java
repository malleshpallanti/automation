package com.automationpratice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilitymethods.Utility_Seleniummethods;

public class AddToCart {

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement Women;
	@FindBy(xpath="//*[@title='Blouses']")
	WebElement blouses; 
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")
	WebElement itemimage; 
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")
	WebElement more; 
	@FindBy(xpath="//*[@id='quantity_wanted']")
	WebElement qty;
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement size;
	@FindBy(xpath="//*[@id='add_to_cart']/button[@type='submit']")
	WebElement Addtocart;
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	WebElement checkout;
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
	WebElement carttext;
	
	Utility_Seleniummethods selenium = new Utility_Seleniummethods();
	
	public AddToCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAddCart(WebDriver driver) {
		
		selenium.perforMouseover(Women, driver);
		selenium.click(blouses);
		selenium.ScrollJavaScriptExectutor(itemimage, driver);
		selenium.perforMouseover(itemimage, driver);
		selenium.click(more);
		selenium.click(qty);
		selenium.clear(qty);
		selenium.setText("2", qty);
		selenium.selectByVisibleText(size, "M");
		selenium.click(Addtocart);
		selenium.clickusingJavaScriptExecutor(checkout, driver);
		selenium.refresh(driver);
		 boolean value = selenium.validateText(driver, carttext, "2");
		
		return value;
	}
	
}
