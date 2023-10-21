package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {
	
	WebDriver driver;
	
	
	public Login_page(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
		
	}
	
			//two ways of putting locators in library
			// @FindBy method - stores as webelements
			//By method - stores as locatores
			
			//@findby method
			@FindBy(id ="user-name")
			WebElement username;
			
			@FindBy(xpath="//input[@name = 'password']")
			WebElement password;
			
			//by method
			
			By loginbutton = By.id("login-button");
			
			public void enterUsername(String user) {
				username.sendKeys(user);
			}
			
			public void enterPassword(String pass) {
				password.sendKeys(pass);
			}
			
			public void clickOnLoginButton(){
				
				driver.findElement(loginbutton).click();
			}
			
			//making code shorter
			
			public void loginToSauseDemo(String user, String pass){
				username.sendKeys(user);
				password.sendKeys(pass);
				
				driver.findElement(loginbutton).click();
			}
}
