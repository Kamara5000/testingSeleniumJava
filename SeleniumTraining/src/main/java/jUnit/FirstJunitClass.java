package jUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Constants;
import pages.Login_page;

public class FirstJunitClass {
	
	//test frameworks helps to organise your tests so its readable and easy
	//annotations - @Before, @After, @BeforeClass @AfterClass @Test
	//@After - runs after every test
	//@Before- runs before every test
	//@BeforeClass - run before all code
	//@AfterClass - run after all your code
	//@Test - this is the test code
	
	WebDriver driver;
	
//	@Before
//	public void before() {
//		System.out.println("run before every tests");
//	}
//	
//	@After
//	public void after() {
//		System.out.println("run after every tests");
//	}
//	
//	@Test
//	public void Test_One() {
//		System.out.println("this is test case one");
//	}
//	
//	@Test
//	public void Test_Two() {
//		System.out.println("this is test case two");
//	}
	
	@Before
	public void before() {
		driver = library.Browsers.launchBrowser("chrome");
		
		driver.get(Constants.URL);
	}
	
	@After
	public void after() {
		driver.quit();
	} 
	
	@Test
	public void Login_Test_1() {
		
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo("standard_user", "secret_sauce");
		

	}
	
	@Test
	public void Login_Test_2() {
		
		
		Login_page login = new Login_page(driver);
		
		login.loginToSauseDemo("standard_user", "secret_sauce");
		
		driver.quit();

	}
}
