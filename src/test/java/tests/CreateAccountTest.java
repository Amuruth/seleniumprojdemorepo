package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class CreateAccountTest extends Base{
	public WebDriver driver;
	
	@Test
	public void careateAccount() throws IOException, InterruptedException {
		
		System.out.println("successfully created account page");
		
		driver = initializeDriver();
		
		driver.get("https://www.selenium.dev/downloads/");
		
		Thread.sleep(2000);
		
		driver.close();
	
	}

}
