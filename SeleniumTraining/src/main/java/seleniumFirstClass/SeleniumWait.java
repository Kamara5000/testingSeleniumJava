package seleniumFirstClass;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {
	
	WebDriver driver;
	
	@Test
	public void SeleniumWait() {
		
		driver = library.Browsers.launchBrowser("firefox");
		
		driver.get("https://www.propertypal.com/)");
		
		//implicit wait
		//pauses for a set amount of time
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			//driver.findElement(By.xpath("//span[text()='AGREE']/..")).click();	
		
		//explicit wait
		//conditional wait where condition has to be met before the next line of code run
		//it doesnt wait for the whole time the code continue to run once the condition is met
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='AGREE']/..")));
			
			//driver.findElement(By.xpath("//span[text()='AGREE']/..")).click();
			
			
		//Fluent wait
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
			
			wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//span[text()='AGREE']/.."));
				}
			});
			
			driver.findElement(By.xpath("//span[text()='AGREE']/..")).click();
			
			
			
		driver.quit();
	}

}
