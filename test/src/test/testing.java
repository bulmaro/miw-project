package test;

import static org.junit.Assert.*;

import java.util.List;
//import java.awt.List;
import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testing {
	public WebDriver driver;
	public static WebDriver startDriver(Browsers browserType)
	{
	    switch (browserType)
	    {
	        case FIREFOX:
	            System.setProperty("webdriver.gecko.driver", "/Users/bulmaro/eclipse/selenium-java-3.141.59/geckodriver");
	            return new FirefoxDriver();
	        case CHROME:
	            System.setProperty("webdriver.chrome.driver", "/Users/bulmaro/eclipse/selenium-java-3.141.59/chromedriver");
	            return new ChromeDriver();
	        case IE32:
	            return new InternetExplorerDriver();
	        case IE64:
	            return new InternetExplorerDriver();
	        default:
	            throw new InvalidParameterException("Unknown browser type");
	    }
	}
	public enum Browsers
	{
	    CHROME, FIREFOX, IE32, IE64;
	}

	@Test
	public void test_google_load() {
		WebDriver driver = startDriver(Browsers.CHROME);
		driver.get("http://www.google.com");
		WebElement searchText;
		WebElement searchButton;
        WebElement elementBtnLucky;
		try {
			searchText = driver.findElement(By.name("q")); 
			searchButton = driver.findElement(By.name("btnK"));
	        elementBtnLucky = driver.findElement(By.name("btnI"));
		}
		finally {
			driver.close();	
		}
	}
	
	@Test
	public void test_google_find_miw() 
	{
		WebDriver driver = startDriver(Browsers.CHROME);
		driver.get("http://www.google.com");
		WebElement searchText;
		try {
			searchText = driver.findElement(By.name("q")); 
		    searchText.sendKeys("mobile integration workgroup");
		    searchText.submit();
		    
		    WebElement miw = driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[1]/link"));
		    
		    System.out.println( miw.getAttribute("href"));
		 
		    assertEquals(miw.getAttribute("href"), "https://miwtech.com/");
		}
		finally {
			driver.close();	
		}
	}
	
	@Test
	public void test_auction() 
	{
		WebDriver driver = startDriver(Browsers.CHROME);
		driver.get("https://www.rbauction.com");
		try {
			WebElement arrow;
			Thread.sleep(500);
			arrow = driver.findElement(By.id("adv-toggle-down"));
			arrow.click();
			
			WebElement searchText;
			Thread.sleep(500);
			searchText = driver.findElement(By.id("adv-keyword")); 
		    searchText.sendKeys("excavator");
			Thread.sleep(500);
			WebElement category;
			category = driver.findElement(By.id("adv-category"));
			category.sendKeys("Construction");
			Thread.sleep(500);
		    WebElement yearFrom;
		    yearFrom = driver.findElement(By.id("adv-year-min"));
		    yearFrom.sendKeys("2016");
			Thread.sleep(500);
		    WebElement make;
		    make = driver.findElement(By.id("adv-make"));
		    make.sendKeys("CATERPILLAR");    
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();	
		}
	}
}