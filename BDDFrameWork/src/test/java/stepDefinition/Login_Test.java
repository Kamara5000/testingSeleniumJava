package stepDefinition;

import Pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import library.Constants;
import utilities.Base_Util;

public class Login_Test extends Base_Util {
	
	 private Base_Util base;
	 public Login_Test(Base_Util base) {
		 this.base = base;
	 }
	
	
		@Given ("user opens URL")
		public void user_opens_URL() {
			base.driver.get(Constants.URL);
		}
		
		@When  ("user enters username")
		public void user_enters_username() {
			Login_Page page = new Login_Page(base);
			page.enterUsername(Constants.STANDARD_USER);
		}
		
		@And  ("user enters password")
		public void user_enters_password() {
			Login_Page page = new Login_Page(base);
			page.enterPassword(Constants.PASSWORD);
		}
		
		@Then ("click the login button")
		public void click_the_login_button() {
			Login_Page page = new Login_Page(base);
			page.clickOnLoginButton();
		}
		
		@Then ("user to see homepage")
		public void go_to_user_to_see_homepage() {
			String expectedHomePageURL = Constants.HOMEPAGE_URL;
			String actualHomePageURL = base.driver.getCurrentUrl();
			
			Assert.assertEquals(expectedHomePageURL, actualHomePageURL);
		}
		
		
		@Given ("user opens login url")
		public void user_opens_login_url() {
			base.driver.get(Constants.URL);
		}
		
		@Given("user input wrong credentials")
		public void user_input_wrong_credentials() {
			Login_Page page = new Login_Page(base);
			page.enterUsername(Constants.STANDARD_USER);
			page.enterPassword("dfgfgfd");
			page.clickOnLoginButton();
		}
		
		@Then("user remains in login page")
		public void user_remains_in_login_page() {
			String expectedLoginPage = Constants.LOGIN_Page;
			String actualLoginPage= base.driver.getCurrentUrl();
			
			Assert.assertEquals(expectedLoginPage, actualLoginPage);
		
		}
}
