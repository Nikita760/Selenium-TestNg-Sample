package com.automation.test.selenium;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WikipediaGoogleTestExample {

	WebDriver driver;
	String baseURL1;
	String baseURL2;

	@BeforeMethod
	public void openBrowser() throws Exception {
		//Open the browser and maximize before each test case
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//Global wait which applies to all the elements on the web page
		//wait for 20 seconds, if the element is not found within 20 seconds, throw an exception
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() throws Exception {
		//Open the browser and maximize before each test case
		driver.close();
	}
	
	@Test(priority=1)
	public void testWikipediaSearchOnFirefox() throws InterruptedException {
		baseURL1 = "http://wikipedia.com";
		driver.get(baseURL1);
		// 30 seconds
        WebElement searchBox = driver.findElement(By.id("searchInput"));
		
		searchBox.sendKeys("Green Bay Packers");
		
		Thread.sleep(1000);
		
		//30 seconds
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		searchButton.click();
		
		//Waiting for 2 seconds
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void testGoogleSearchOnFirefox() throws InterruptedException{
		/*baseURL2 = "http://www.google.com";
		driver.get(baseURL2);
        
		driver.findElement(By.id("lst-ib")).sendKeys("Green Bay Packers");
		
		Thread.sleep(2000)*/;
		throw new SkipException("Skipping the google test");
		
	}
	@BeforeTest
	public void oneTimeLogging(){
		System.out.println("Beginning the tests");
	}
	@AfterTest
	public void closeLogging(){
		System.out.println("Tests finished");
	}
	
}
