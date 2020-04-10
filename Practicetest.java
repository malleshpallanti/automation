package com.automationframework;

import org.testng.annotations.Test;
import com.automationframework.main.Excelinput;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Practicetest {

	WebDriver driver;

	@BeforeClass
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver 80.0.3987.16\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("==========Browser Started==========");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void accountRegister() throws InterruptedException {

		// Step 1 : click on signIn link

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement signin = driver.findElement(By.cssSelector("a[class='login']"));
		wait.until(ExpectedConditions.elementToBeClickable(signin)).click();

		// Step 2 : ---> directs to ---> My account page for registration

		String currentURL = driver.getCurrentUrl();
		System.out.println("The current URL : " + currentURL);

		WebElement email = driver.findElement(By.xpath("//*[@id='email_create']"));
		wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("dammy34@gmail.com");

		WebElement submit = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();

		// Step 3 : ---> direct to ---> account creation page ---> for details

		WebElement gender = driver.findElement(By.cssSelector("#id_gender1"));
		wait.until(ExpectedConditions.elementToBeClickable(gender)).click();

		WebElement customer_firstname = driver.findElement(By.cssSelector("#customer_firstname"));
		wait.until(ExpectedConditions.elementToBeClickable(customer_firstname)).sendKeys("RNB");

		WebElement customer_lastname = driver.findElement(By.cssSelector("#customer_lastname"));
		wait.until(ExpectedConditions.elementToBeClickable(customer_lastname)).sendKeys("CSI");

		WebElement password = driver.findElement(By.cssSelector("#passwd"));
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("password@1");

		driver.findElement(By.xpath("//*[@id='days']")).click();
		WebElement day = driver.findElement(By.xpath("//*[@id='days']"));
		Select s1 = new Select(day);
		s1.selectByIndex(14);

		driver.findElement(By.xpath("//*[@id='months']")).click();
		WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
		Select s2 = new Select(month);
		s2.selectByIndex(8);

		driver.findElement(By.xpath("//*[@id='years']")).click();
		WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
		Select s3 = new Select(year);
		s3.selectByIndex(33);

		WebElement address_firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		wait.until(ExpectedConditions.elementToBeClickable(address_firstname)).sendKeys("RNB");

		WebElement address_lastname = driver.findElement(By.xpath("//*[@name='lastname']"));
		wait.until(ExpectedConditions.elementToBeClickable(address_lastname)).sendKeys("CSI");

		WebElement company_name = driver.findElement(By.xpath("//*[@id='company']"));
		wait.until(ExpectedConditions.elementToBeClickable(company_name)).sendKeys("xyz");

		WebElement address = driver.findElement(By.xpath("//*[@id='address1']"));
		wait.until(ExpectedConditions.elementToBeClickable(address)).sendKeys("flot201,new chruch street");

		WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
		wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys("Alameda");

		WebElement State = driver.findElement(By.xpath("//*[@id='id_state']"));
		Select s = new Select(State);
		s.selectByVisibleText("California");

		WebElement pincode = driver.findElement(By.xpath("//*[@id='postcode']"));
		wait.until(ExpectedConditions.elementToBeClickable(pincode)).sendKeys("20122");

		WebElement mobile_no = driver.findElement(By.cssSelector("#phone_mobile"));
		wait.until(ExpectedConditions.elementToBeClickable(mobile_no)).sendKeys("+15106832134");

		WebElement alias = driver.findElement(By.cssSelector("#alias"));
		wait.until(ExpectedConditions.elementToBeClickable(alias)).sendKeys("My Address");

		WebElement RegisterAccount = driver.findElement(By.cssSelector("#submitAccount"));
		wait.until(ExpectedConditions.elementToBeClickable(RegisterAccount)).click();

		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);

		Assert.assertTrue(title.equals("My account - My Store"), "User registration failure");

	}

	@Test(dependsOnMethods = "accountRegister")
	public void login_Orderbooking() {

		System.out.println("Account Created and Login Successfully completed");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(women));
		Actions a = new Actions(driver);
		a.moveToElement(women).build().perform();

		WebElement blouses = driver.findElement(By.xpath("//*[@title='Blouses']"));
		wait.until(ExpectedConditions.elementToBeClickable(blouses)).click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,500)");

		WebElement quickview = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
		a.moveToElement(quickview).build().perform();

		WebElement quickviewclick = driver
				.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/div[1]/a/i"));
		jse.executeScript("arguments[0].click()", quickviewclick);

		WebElement qty = driver.findElement(By.xpath("//*[@id='quantity_wanted']"));
		wait.until(ExpectedConditions.elementToBeClickable(qty)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(qty)).sendKeys("2");

		WebElement addcart = driver.findElement(By.xpath("//*[@id='add_to_cart']/button[@type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(addcart)).click();

		System.out.println(" No.of Orders added 2 ");

	}

	@Test(dependsOnMethods = "login_Orderbooking")
	public void checkOut() {

		WebElement checkout = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", checkout);

		driver.navigate().refresh();
		jse.executeScript("scroll(0,500)");

		WebElement element = driver
				.findElement(By.xpath("//td[@id='total_price_container']/span[contains(text(),'56.00')]"));
		String qtyvalue = element.getText();
		String expectedtext = "$56.00";

		Assert.assertEquals(qtyvalue, expectedtext);

		System.out.println(" the price 0f 2 orders is : " + qtyvalue);

	}

	@Test(dependsOnMethods = "checkOut")
	public void ordersConfirmation() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id='center_column']/form/p/button")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='uniform-cgv']"))))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"))))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a")))).click();

		String title = driver.getTitle();
		System.out.println(title);

		Assert.assertTrue(title.equals("Order history - My Store"), "Order has not been booked");

		System.out.println("Order has been booked successfully");
	}

	@Test(dependsOnMethods = "ordersConfirmation")
	public void OrderHistory() {

			
		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"order-list\"]//td[3]/span[@class=contains(text(),'$56.00')]"));
		String qtyvalue = element.getText();
		System.out.println(qtyvalue);
		String expectedtext = "$56.00";
		
		Assert.assertEquals(qtyvalue, expectedtext);
		
	}

	@AfterClass
	public void browserclose() {

		System.out.println("Thank you for your shopping");

	}

}
