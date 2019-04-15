package com.project.NaveenSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchUsingExcelData {

	public static void main(String[] args) throws Exception {

		ExcelAPI e = new ExcelAPI("C:\\Users\\C5270459\\Desktop\\testdata.xlsx");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		 int rCnt = e.getRowCount("login");
		 
		 for ( int i=1;i<rCnt;i++) 
		 {
			 driver.findElement(By.id("email")).clear();
			 driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			 Thread.sleep(3000);
			 driver.findElement(By.id("pass")).clear();
			 driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
		 }
		 

	}

}
