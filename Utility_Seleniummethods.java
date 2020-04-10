package com.utilitymethods;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utility_Seleniummethods {

		public void waitcondition(WebDriver driver, WebElement element){
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
		
		Actions action;
		public void perforMouseover(WebElement element, WebDriver driver) {
			
			action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		
		public void click(WebElement element) {
			element.click();
		}
		
		public void clear(WebElement element) {
			element.clear();
		}
		
		public void setText(String text, WebElement element) {
			element.sendKeys(text);
		}
		
		public void selectByVisibleText( WebElement selectsize, String text) {
			Select s = new Select(selectsize);
			s.selectByVisibleText(text);
		}
		
		public void selectByIndex(WebElement element, int index) {
			Select s = new Select(element);
			s.selectByIndex(index);
		}
		
		public void clickusingJavaScriptExecutor(WebElement element, WebDriver driver) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
		public void ScrollJavaScriptExectutor(WebElement element, WebDriver driver) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("scroll(0,500)");
		}
		
		public void refresh(WebDriver driver) {
			driver.navigate().refresh();
		}
		
		public boolean validateText(WebDriver driver, WebElement element, String exepectedText ) {
			String actualText = element.getText();
			if(actualText.equals(exepectedText)) {
				return true; 
			}
			return false; 
		}
}
