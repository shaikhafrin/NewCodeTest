package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNewProject {
	public WebDriver driver;
	Logger logger = Logger.getLogger("TestNewProject");
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void login(String browser,String url){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\848316\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("chrome driver launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	//(dataProvider="SearchProvider",alwaysRun = true)
	    @Parameters({"username"})
		@Test
		public void registerUser(String username){
			driver.findElement(By.name("firstname")).sendKeys(username);
			
		}
		
		@DataProvider(name="SearchProvider")
        @Parameters({"fileName"})
		public static ArrayList<Object[]> getDataFromExcel(String fileName,String firstname,String lastname,String email,String password) throws IOException{
			
			ArrayList<Object[]> mydata = new ArrayList<Object[]>();
			File file = new File("C:\\Users\\848316\\OneDrive - Cognizant\\Desktop"
					+ "\\"+fileName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook book = null;
			String fileExtentionName = fileName.substring(fileName.indexOf("."));
			System.out.println(fileExtentionName);
			
			if(fileExtentionName.equals(".xlsx")){
				
				book = new XSSFWorkbook(inputStream);
				Sheet sheet = book.getSheet("records");
				int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
				for (int i = 0; i < rowCount+1; i++) {
					Row row = sheet.getRow(i);
					for (int j = 0; j < row.getLastCellNum(); j++) {
					  firstname = sheet.getRow(i).getCell(j).getStringCellValue();
					  lastname = sheet.getRow(i).getCell(j+1).getStringCellValue();
					  email = sheet.getRow(i).getCell(j).getStringCellValue();
					  password = sheet.getRow(i).getCell(j).getStringCellValue();
					}
					System.out.println();
				}
				Object obj[]= {firstname,lastname,email,password};
			    mydata.add(obj);
				}
			return mydata;	
			
		}
	
	

}
