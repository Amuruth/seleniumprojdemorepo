package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	public WebDriver driver;
	
	@Test
	public void testTwo() throws IOException, InterruptedException {
		
		System.out.println("Amuruth has updated this code");
		System.out.println("Test two");	
		driver = initializeDriver();
		
		driver.get("https://www.selenium.dev/downloads/");
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
