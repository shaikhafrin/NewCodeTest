package com.product.tc;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.product.po.PO_search;
import com.product.util.BrowserManager;

public class TC_HealthCheck {

	 
	@Test
	@Parameters({"browser", "url"})
	public void tc_01_csmart_search( @Optional("chrome")String browser,@Optional("https://demo.cs-cart.com/")String url){
		
	WebDriver driver = BrowserManager.getDriver(browser,url);
	PO_search obj =PageFactory.initElements(driver, PO_search.class);
	obj.searchAProduct("computer");
	
	}
}
