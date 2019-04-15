package com.project.NaveenSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataByName {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheet("login");
		  XSSFRow row = sheet.getRow(0);
		  XSSFCell cell = null;
		  
		  int colNumber = 0;
		  for ( int i=0;i<row.getLastCellNum();i++) {
			  if(row.getCell(i).getStringCellValue().trim().equals("Password"))
				  colNumber=i;
		  }
		  row = sheet.getRow(4);
		  cell = row.getCell(colNumber);
		  String password = cell.getStringCellValue();
		  System.out.println("Value of the password :"+password);
		  workbook.close();
		  fis.close();
		 

	}

}
