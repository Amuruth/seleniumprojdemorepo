package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	Logger log;
	
	public WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
				
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on my Account Dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login Option");
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressFeild().sendKeys(email);
		log.debug("Email address got enterd");
		loginPage.passwordFeild().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on login Button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
		
		try {
			
			if(accountPage.editAccountInformationOption().isDisplayed()) {
				log.debug("User got logged In");
			    actualResult = "Successful";
			}
			//System.out.println("Inside the try block");
			
		}catch(Exception e) {
			//System.out.println("Inside catch block");
			log.debug("User didn't logged In");
			actualResult = "Failed";
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login Test got Passed");
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got lanuched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"arun.selenium@gmail.com","Second@123","Successful"}};
		return data;
	}

}
