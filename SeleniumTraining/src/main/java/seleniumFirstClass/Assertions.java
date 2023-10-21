package seleniumFirstClass;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Assertions {
	
	WebDriver driver;
	
	@Test
	public void Assertions() {
		
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		
		
		//to assert an element is displayed on the page
		WebElement image = driver.findElement(By.xpath("//div[@id='login_button_container']/../div[2]"));
		boolean status = image.isDisplayed();
		System.out.println(status);
		Assert.assertTrue(status);
		
		driver.findElement(By.id("login-button")).click();
		
		String expectedHomeUrl = "https://www.saucedemo.com/inventory.html";
		String actualHomeUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedHomeUrl, actualHomeUrl);
		
		
		
		driver.quit();
		
		
	}
}
