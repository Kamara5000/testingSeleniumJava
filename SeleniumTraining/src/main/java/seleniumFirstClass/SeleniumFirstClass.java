package seleniumFirstClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirstClass {
	
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		
		//using the browser  library
		//driver = library.Browsers.launchBrowser("chrome");
		
		driver = library.Browsers.launchBrowser("firefox");
		
		driver.get("https://saucedemo.com");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		String expectedHomeUrl = "https://www.saucedemo.com/inventory.html";
		String actualHomeUrl = driver.getCurrentUrl();
		boolean status = expectedHomeUrl == actualHomeUrl;
		
		System.out.println(status);
		
		
		
		
		
		
		
		driver.quit();
		
		
		
	}

}
