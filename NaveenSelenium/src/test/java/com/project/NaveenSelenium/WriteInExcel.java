package com.project.NaveenSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel 
{
	public static final String EXCELFILELOCATION ="C:\\Users\\C5270459\\Desktop\\WriteData.xlsx";

	public static void main(String[] args) throws Exception 
	{
		File file = new File(EXCELFILELOCATION);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("People");
		int rowCount = sheet.getLastRowNum()+1;
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for ( int i=1;i<rowCount;i++)
		{
				XSSFCell cell = sheet.getRow(i).getCell(1);
				String celltext = "";
			//get the celltype value
			if(cell.getCellType()==CellType.STRING) 
			{
				celltext = cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC)
			{
				celltext = String.valueOf(cell.getNumericCellValue());
			}
			else if (cell.getCellType()==CellType.BLANK)
			{
				celltext="";
			}
			if(Double.parseDouble(celltext)>=18)
			{
				sheet.getRow(i).getCell(2).setCellValue("Major");
			}
			else
			{
				sheet.getRow(i).getCell(2).setCellValue("Minor");
			}
		}
			fis.close();
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
		
	}

}
