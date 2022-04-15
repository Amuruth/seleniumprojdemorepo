package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base{
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	

    @Given("^Open any Browser$")
    public void open_any_browser() throws IOException {
    	
    	driver = initializeDriver();
        
    }
    

    @And("^Naviagte to Login Page$")
    public void naviagte_to_login_page() throws InterruptedException {
    	
    	driver.get(prop.getProperty("url"));
    	landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		Thread.sleep(3000);
        
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the feilds$")
    public void user_enters_username_as_something_and_password_as_something_into_the_feilds(String email, String password) {
    	
    	loginPage = new LoginPage(driver);
    	loginPage.emailAddressFeild().sendKeys(email);
    	loginPage.passwordFeild().sendKeys(password);
        
    }
    
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
    	
    	loginPage.loginButton().click();
        
    }

    @Then("^verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
        
    }
    
    @After
    public void closeBrowser() {
    	
    	driver.close();
    }

}
