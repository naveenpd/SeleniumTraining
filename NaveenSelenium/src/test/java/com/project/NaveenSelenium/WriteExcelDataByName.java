package com.project.NaveenSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByName {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row = null;
		XSSFCell cell = null;
		
//		sheet = workbook.getSheet(sheetName);
//		row = sheet.getRow(0);
//		int columnCount = row.getLastCellNum();
		
		int colNumber =0;
		 row = sheet.getRow(0);
//		 int rowCount = sheet.getLastRowNum();
//		 int columnCount = row.getLastCellNum();
//		 System.out.println(columnCount);
		 for( int i=0;i<row.getLastCellNum();i++) 
		 {
//			 System.out.println(row.getCell(i).getStringCellValue());
			 if(row.getCell(i).getStringCellValue().trim().equals("Results")) {
//				 System.out.println(i);
				 colNumber = i;
				 break;
			 }
				
		 }
//		 System.out.println(colNumber);
		 row = sheet.getRow(4);
		 cell= row.getCell(colNumber);
		 cell.setCellValue("Aborted");
		 
		 fos = new FileOutputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		 workbook.write(fos);
		 fos.close();
		 System.out.println("Written");
		 
		 

	}

}
