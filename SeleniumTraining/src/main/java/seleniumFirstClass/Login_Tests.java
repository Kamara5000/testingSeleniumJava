package seleniumFirstClass;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.Constants;
import pages.Login_page;

public class Login_Tests {
	
WebDriver driver;
	
	//page object model POM - makes your code readable, reusable and easy to maintain
	//it is a library of locators and methods that can be reused
	
	@Ignore
	public void Login_Test_1() {
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get("https://www.saucedemo.com/");
		
		Login_page login = new Login_page(driver);
		
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		
//		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
//		
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		
//		driver.findElement(By.id("login-button")).click();
		
		driver.quit();

	}
	
	@Ignore
	public void Login_Test_2() {
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get("https://www.saucedemo.com/");
		
		Login_page login = new Login_page(driver);
		
		login.enterUsername("locked_out_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		
		driver.quit();

	}
	

	@Ignore
	public void Login_Test_3() {
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get("https://www.saucedemo.com/");
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo("standard_user", "secret_sauce");
		
		driver.quit();

	}
	
	
	//working with constant and page object
	@Ignore
	public void Login_Test_4() {
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get(Constants.URL);
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo(Constants.STANDARD_USER, Constants.PASSWORD);
		
		driver.quit();

	}
	
	@Ignore
	public void assertText() {
		
		driver = library.Browsers.launchBrowser("firefox");
		
		driver.get(Constants.URL);
		Login_page login = new Login_page(driver);
		
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		
		WebElement itemTitle = driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
		
		String text = itemTitle.getText();
		String expectedText = "Sauce Labs Backpack";
		
		assertEquals(text, expectedText);
		
		driver.quit();
	}
	
	@Ignore
	public void assertElementDisplayed() {
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get(Constants.URL);
		Login_page login = new Login_page(driver);
		
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginButton();
		
		WebElement sauceLabImage = driver.findElement(By.xpath("//div[@id = 'login_button_container]/../div[2]"));
		 boolean status = sauceLabImage.isDisplayed();
		 
		 assertTrue(status);
		 
		 assertFalse(status);
		 
		 System.out.print(status);
		 
		 driver.quit();
	}
	
	@Ignore
	public void assertingAttributes() {
		//asserting css values
		//colours -
		//font size
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get(Constants.URL);
		Login_page login = new Login_page(driver);
		
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
				
		String colour = loginButton.getCssValue("background-color");
		String expectedColour = "rgb(226,35,26  )";
		
		System.out.println(colour);
		
		assertEquals(expectedColour,colour);
		
		driver.quit();
	}
	
	@Test
	public void assertTextNexudus() {
		
		
		
		
//		Login_page login = new Login_page(driver);
//		
		driver = library.Browsers.launchBrowser("firefox");
		driver.get("https://www.nexudus.com/");
		
		driver.findElement(By.xpath("//a[@class='btn btn-outline-dark btn-aqua']")).click();
		
		WebElement itemTitle = driver.findElement(By.xpath("//h1[@class='h2 jumbotron__title']"));
	
		String text = itemTitle.getText();
		String expectedText = "Contact Us";
		
		assertEquals(text, expectedText);
		
		driver.quit();
	}
}
