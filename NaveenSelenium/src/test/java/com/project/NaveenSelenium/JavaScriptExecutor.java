package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class JavaScriptExecutor {
 WebDriver driver;
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver =new ChromeDriver();
		String url= "https://www.facebook.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
  }
  
  @Test
  public void facebook() throws Exception {
	  
	  // when we fail to perform action using webdriver methods or on hidden elements then we wil go for javascript executor
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('email').value='Naveen'");
//		js.executeScript("document.getElementById('pass').value='password'");
//		js.executeScript("document.getElementById('loginbutton').click()");
//		String str = js.executeScript("return document.title").toString(); //convert into string
//		System.out.println(str);
//		js.executeScript("window.scrollBy(0,100)");
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");// to scroll down to page
//		js.executeScript("document.getElementById('reg_pages_msg').scrollIntoView()");//scroll to specific locator
	  js.executeScript("window.history.back()");// move to backward page
	  Thread.sleep(2000);
	  js.executeScript("window.history.forward()");//move to forward page
	  Thread.sleep(3000);
	  js.executeScript("window.history.go(0)");// to refresh the page
  }
  
  

  @AfterMethod
  public void afterMethod() {
  }

}
