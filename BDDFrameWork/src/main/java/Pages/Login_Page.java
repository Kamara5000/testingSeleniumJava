package Pages;

import org.openqa.selenium.By;

import utilities.Base_Util;

public class Login_Page extends Base_Util {
	
	private Base_Util base;
	
	public Login_Page(Base_Util base) {
		this.base = base;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	public void enterUsername(String user) {
		base.driver.findElement(username).sendKeys(user);
		
	}
	
	public void enterPassword(String pword) {
		base.driver.findElement(password).sendKeys(pword);
	}
	
	public void clickOnLoginButton () {
		base.driver.findElement(loginButton).click();
	}
	
}
