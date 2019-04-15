package com.project.NaveenSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByIndex {

	public static void main(String[] args) throws Exception {
		
		//Excel programs
		// https://poi.apache.org/components/spreadsheet/quick-guide.html
		
		FileInputStream fis = new FileInputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row = null;
		XSSFCell cell= null;
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style = workbook.createCellStyle();
		row = sheet.getRow(4);
		cell = row.getCell(4);
		font.setFontName("Algeria");
		font.setFontHeight(10.0);
		font.setBold(true);
		style.setFont(font);
		cell.setCellStyle(style);
		cell.setCellValue("Stop");
		fos = new FileOutputStream("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		workbook.write(fos);
		fos.close();
		
		

	}

}
