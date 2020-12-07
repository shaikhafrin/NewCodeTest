package com.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_search {

	WebDriver driver;
	public PO_search(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.NAME, using="hint_q")
	WebElement searchbox;
		
	
	@FindBy(how=How.CLASS_NAME, using="ty-search-magnifier")
	WebElement search_btn;
	
	public void searchItem(String arg){
		searchbox.sendKeys(arg);
		Reporter.log("product enter is:"+arg,true);
	}
	public void clickSearch(){
		search_btn.click();
		Reporter.log("search button clicked", true);
	}
	
	
	public void searchAProduct(String arg){
		searchItem(arg);
		clickSearch();   
		
		String actual = driver.getTitle();
		String expected = "Search results";
		Assert.assertEquals(actual, expected, "app not able to search the product");
		Reporter.log("search the product successfully"+arg);
		
	}
}
