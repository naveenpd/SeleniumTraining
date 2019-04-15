package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class ActionClass {
	WebDriver driver;
	Actions a;
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver =new ChromeDriver();
//		String url= "https://www.amazon.in/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
  }
  
  @Test(priority=0,enabled=false)
  public void moveToElement() 
  {
	  driver.get("https://www.amazon.in/");
	  a= new Actions(driver);
	  a.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Your Orders')]"))).perform();
	  driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
	  
  }
  @Test(priority=1,enabled = false)
  public void dragAnddrop()
  {
	  driver.get("http://jqueryui.com/droppable/");
	  driver.switchTo().frame(0);
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  
	  a = new Actions(driver);
//	  a.dragAndDrop(drag, drop).perform(); // one action we use only perform
//	  a.dragAndDrop(drag, drop).build().perform();
	  a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform(); // multiple we use build and perform
  }
  
  @Test (priority = 2, enabled = false)
  public void reSize() {
	  driver.get("http://jqueryui.com/resizable/");
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement drag = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
	  a= new Actions(driver);
//	  a.moveToElement(drag, 300, 200).perform();
	  a.clickAndHold(drag).moveByOffset(300, 300).release(drag).build().perform();
//	  a.dragAndDropBy(drag, 300, 100);
  }
  
  @Test(enabled=false)
  public void rightClickMethod() throws Exception 
  {
	  driver.get("http://jqueryui.com/");
	  WebElement sel = driver.findElement(By.linkText("Selectable"));
	  a = new Actions(driver);
//	  a.contextClick(sel).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
	  a.contextClick(sel).perform();
	  Robot robot = new Robot();
	  Thread.sleep(2000);
	  robot.keyPress(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robot.keyPress(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	 
  }
  
  @Test (priority = 2, enabled = false)
  public void slider() {
	  driver.get("http://jqueryui.com/slider/");
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement drag = driver.findElement(By.xpath("//div[@id='slider']/span"));
	  a= new Actions(driver);
	  a.dragAndDropBy(drag, 300, 0).perform();
//	  a.clickAndHold(drag).moveByOffset(400, 0).release(drag).build().perform();
	  
  }
  
  @Test (priority = 2, enabled = false)
  public void broswerslider() throws Exception {
	  driver.get("https://www.seleniumhq.org/");
	  for ( int i=0;i<5;i++) {
		  ((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)");
		  Thread.sleep(2000);
	  }
	  
	  
  }
  
  @Test (priority = 2, enabled = false)
  public void autoSuggestion() throws Exception {
	  driver.get("https://www.google.com/");
	  driver.findElement(By.name("q")).sendKeys("selenium");
	  List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']/li/div/div/div/span"));
	  for ( int i=0;i<list.size();i++) {
		  String text = driver.findElement(By.name("q")).getAttribute("value");
		  System.out.println(list.get(i).getText());
		  if(list.get(i).getText().equals(text)) {
			  list.get(i).click();
			  break;
		  }
	  }
	  
	  
  }
  @Test
  
  public void text() {
	  driver.get("https://www.facebook.com/");
	  driver.findElement(By.id("email")).sendKeys("naveen.likes.you");
	  System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
