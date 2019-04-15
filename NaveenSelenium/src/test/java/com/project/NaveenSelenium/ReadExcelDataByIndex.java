package com.project.NaveenSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataByIndex {
  @Test
  public void Excel() throws IOException 
  {
	  FileInputStream fis = new FileInputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
	  XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sheet = workbook.getSheet("login");
	  XSSFRow row = sheet.getRow(4);
	  XSSFCell cell = row.getCell(1);
	  String value = cell.getStringCellValue();
	  System.out.println("Value of the Cell :"+value);
	  workbook.close();
	  fis.close();
	 
	 
	  
  }
}
