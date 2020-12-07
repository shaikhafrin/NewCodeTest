package com.product.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class BrowserManager {
	
	public static WebDriver driver;
	
	
	public static WebDriver getDriver(String type,String url){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\848316\\Downloads\\chromedriver.exe");
		if(type.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("IE")){
			 driver = new InternetExplorerDriver();
		}
		else if(type.equalsIgnoreCase("Firefox")){
			 driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("Navigated to browser:"+type+" &URL"+url);
		return driver;
		
	}

}
