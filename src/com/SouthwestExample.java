package com.automation.test.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SouthwestExample {

	WebDriver driver;
    String baseURL;
    
    @BeforeSuite
    public void loggingBeforeSuite(){
    	System.out.println("Beginning our Test Suite with Wikipedia and Southwest");
    }
    
    @AfterSuite
    public void loggingAfterSuite(){
    	System.out.println("finished our Test Suite with Wikipedia and Southwest");
    }
	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		/*if(driver!=null){
		   driver.close();
		}*/
	}

	@Test
	public void test() throws InterruptedException {
		baseURL = "http://www.southwest.com";
		driver.get(baseURL);
		
		WebElement advancedSearchLink = driver.findElement(By.linkText("Advanced Search"));
		advancedSearchLink.click();
		
		WebElement originAirport = driver.findElement(By.id("originAirport_displayed"));
		originAirport.sendKeys("DEN");
		
		
		WebElement destinationAirport = driver.findElement(By.id("destinationAirport_displayed"));
		destinationAirport.sendKeys("SFO");
		
		WebElement calImage = driver.findElement(By.xpath("//div[@id='departureBookingSelects']/div[1]/img"));
		calImage.click();
		
		List<WebElement> td_List = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr[4]/td"));
		//String depDate = "28";
		for(WebElement td : td_List){
			if(td.getText().equals("28")){
				System.out.println("Found date 28");
				td.findElement(By.linkText("28")).click();
			break;
			}
		}
		
		Thread.sleep(2000);
		
	}
}
