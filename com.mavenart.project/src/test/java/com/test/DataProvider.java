package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvider {
    String fileName="testdata.xlxs";
    static String firstname;
    static String lastname;
    static String email;
    static String password;
	@Test
	public static ArrayList<Object[]> getDataFromExcel(String fileName) throws IOException{
		
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
				  Object obj[]= {firstname,lastname,email,password};
				    mydata.add(obj);
				}
				System.out.println();
			}
			
			}
		return mydata;	
		
	}

	
			
}
