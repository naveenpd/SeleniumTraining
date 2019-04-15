package com.project.NaveenSelenium;

public class TC_Excel{

	public static void main(String[] args) throws Exception {
		
		ExcelAPI e = new ExcelAPI("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		System.out.println(e.getCellData("login", 2, 2));
		System.out.println(e.getCellData("login","Results", 4));
		e.setCellData("login", 4, 4, "Open");
		e.setCellData("login", "UserName", 2, "User4");
		System.out.println(e.getRowCount("login"));
		System.out.println(e.getColumnCount("login"));
	}

}
