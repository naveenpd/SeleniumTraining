package com.project.NaveenSelenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xfilePath;
	
	public ExcelAPI(String xfilePath) throws Exception 
	{
		this.xfilePath = xfilePath;
		fis = new FileInputStream(xfilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public int getRowCount(String sheetName) 
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1; // actual sheet has 5 rows,even its starts with zero
		return rowCount;
		
	}
	public int getColumnCount(String sheetName) 
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
	}
	
	//Reading the cell data using the column number
	public String getCellData(String sheetName, int colNum, int rowNum)
	{
		try {
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell= row.getCell(colNum);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC||cell.getCellType()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) 
				{
					DateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = dt.format(date);
				}
				return cellValue;
			}
			else if (cell.getCellType()==CellType.BLANK) {
				return "";
			}
			else 
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
				
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return "No Matching value";
		}

	}
	// reading the excel data using the column name
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		try
		{
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int colNum = 0;
		  for ( int i=0;i<row.getLastCellNum();i++) 
		  {
//			  System.out.println(row.getCell(i).getStringCellValue());
			  if(row.getCell(i).getStringCellValue().trim().equals(colName)) {
				  colNum=i;
				  break;
			  }
				  
		  }
//		  System.out.println(colNum);
		  row=sheet.getRow(rowNum);
		  cell= row.getCell(colNum);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC||cell.getCellType()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) 
				{
					DateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = dt.format(date);
				}
				return cellValue;
			}
			else if (cell.getCellType()==CellType.BLANK)
			{
				return "";
			}
			else 
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
		}	
		catch(Exception e) 
		{
			e.printStackTrace();
			return "No Matching value";
		}
	}
	//writing the cell data using the column number
	public boolean setCellData(String sheetName, int colNum, int rowNum,String value)
	{
		try
		{
			sheet =workbook.getSheet(sheetName);
			row= sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			cell.setCellValue(value);
			fos = new FileOutputStream(xfilePath);
			workbook.write(fos);
			fos.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//writing the cell data using the column name
	public boolean setCellData(String sheetName, String colName, int rowNum,String value)
	{
		try
		{
			int colNumber =0;
			sheet =workbook.getSheet(sheetName);
			row= sheet.getRow(0);
			 for( int i=0;i<row.getLastCellNum();i++) 
			 {
//				 System.out.println(row.getCell(i).getStringCellValue());
				 if(row.getCell(i).getStringCellValue().trim().equals(colName)) {
//					 System.out.println(i);
					 colNumber = i;
					 break;
				 }
					
			 }
			 row = sheet.getRow(rowNum);
			 cell= row.getCell(colNumber);
			cell.setCellValue(value);
			fos = new FileOutputStream(xfilePath);
			workbook.write(fos);
			fos.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
	

