package seleniumFirstClass;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	WebDriver driver;
	
	@Test
	public void Locators(){
		
		//locators allows selenium to interact with elements
		//attribute and value of attribute
		//static attibutes : these attributes do not change e.g id, name and data tags
		//dynamic attributes : their attributes are change often e.g class, type, data-test
		//types of locator
			// Xpath - //tag[@attributes = 'value'] e.g //input[@name ='user-name']
		
		//locating an element through ancestor
		//note - if an element does not have a static attribute, you find a parent tag that have
		// a static attribute and link it till you reach the element
		//e.g //div[@id='login_button_container']/div/form/div[2]/input
		
		//locating an element through sibling
		//the best to use in this case is to target a closer sibling with a static locator, go up the ladder
		//to a parent tag that have both and return down to the element to be targeted
		//e.g //input[@id='user-name']/../../div[2]/input
		
		//locating through text
		//syntax - //tag[text()='text']
		//e.g //span[text()='AGREE']/..
		
		//locators targetting multiple element
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get("https://saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		//Getting the count of a List
		
		List <WebElement> items = driver.findElements(By.xpath("//div[@id='contents_wrapper']/div[2]/div/div/div/div"));
		
		int count = items.size();
		System.out.println(count);
		
		//GET items name by getting text from the element
		WebElement item = driver.findElement(By.xpath("//a[@id='item_0_title_link']/div"));
		String itemText = item.getText();
		System.out.println(itemText);
		
		//getting text from multiple elements
		 
		List<WebElement> itemTitles = driver.findElements(By.xpath("//a[@id='item_0_title_link']/../../../../div/div[2]/div[1]/a"));
		ArrayList <String> texts = new ArrayList<String>();
		texts.add(itemText);
		
		driver.quit();
	}

}
