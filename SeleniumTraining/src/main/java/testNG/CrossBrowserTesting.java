


package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import library.Constants;
import pages.Login_page;

public class CrossBrowserTesting {
	
	//testng can be imported using the dependency
	//or through the market place by
	//click help button
	//select eclipse marketplace
	//sesrch testng
	//clisk install
	//restart
	
	//to check for result report refresh and click text output then click index.ht ml to view
	
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	
	@Parameters("BrowserName")
	@BeforeMethod
	public void before(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			driver = library.Browsers.launchBrowser("chrome");
		}else if (BrowserName.equalsIgnoreCase("firefox")){
			driver = library.Browsers.launchBrowser("firefox");
		}else if (BrowserName.equalsIgnoreCase("edge")){
			driver = library.Browsers.launchBrowser("edge");
		}else {
			driver = library.Browsers.launchBrowser("chrome");
		}
		
		
		driver.get(Constants.URL);
	}
	
	@AfterMethod
	public void after(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			System.out.println("the test that failed is" + result.getName());
			Shutterbug.shootPage(driver).withName(result.getName()).save();
		}	
		driver.quit();
	} 
	
	@Test
	public void Login_Test_1() {
		
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo(Constants.STANDARD_USER, Constants.PASSWORD);
		
		

	}
	
	@Test
	public void Login_Test_2() {
		
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo(Constants.STANDARD_USER, Constants.PASSWORD);
		
	
	}
	
	
	//using this test suite to check itest result indicating the failed test
	@Test
	public void Login_Test_3() {
		
		
		Login_page login = new Login_page(driver);
	
		login.loginToSauseDemo(3, "secret_sauce"); 
		
		

	}
	
}
