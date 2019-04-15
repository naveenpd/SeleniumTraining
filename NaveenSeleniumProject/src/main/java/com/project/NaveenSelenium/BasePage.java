package com.project.NaveenSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final Logger log = Logger.getLogger(BasePage.class.getName());

	public static WebDriver driver;
	public static final String path = "./data.properties";
	
	public static String loadData(String key) throws Exception {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(path);
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

	public static void launch(String browser, String url) {
		
		
		driver.get(url);
		
	}
	
	public static void click(String locatorKey) throws Exception {
		
		driver.findElement(By.xpath(loadData(locatorKey))).click();
		
	}

	public static void type(String locatorKey, String valueKey) throws Exception {
		
//		driver.findElement(By.id(loadData(locatorKey))).sendKeys(loadData(valueKey));
		WebElement e = getElement(locatorKey);
		e.sendKeys(loadData(valueKey));
		
	}



	public static WebElement getElement(String locatorKey) throws Exception {
		WebElement e = null;
		if(locatorKey.endsWith("_id")) {
			e = driver.findElement(By.id(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			e = driver.findElement(By.name(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			e = driver.findElement(By.name(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			e = driver.findElement(By.linkText(loadData(locatorKey)));
		} else {
			reportFailure("No locator is matching..."+loadData(locatorKey));
		}
		return e;
	}

	public static void reportFailure(String msg) throws IOException {
		takeScreenShot();
		log.info(msg);
		
	}

	public static void takeScreenShot() throws IOException {
		Date dt =new Date();
		String fileName = dt.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(srcFile,new File(System.getProperty("user.dir")+"\\ScreenShot\\"+fileName));
//		FileHandler.copy(srcFile,new File("C:\\Users\\C5270459\\Desktop\\Screenshots\\"+fileName));
	}

	public static void navigate(String urlKey) throws Exception {
		
		driver.get(loadData(urlKey));
		
	}

	public static void openBrowser(String browserKey) throws Exception {
		if(loadData(browserKey).equalsIgnoreCase("CHROME")) {  //Taking value from data.properties
//			if(browserKey.equalsIgnoreCase("CHROME")) { //Taking value from testng.xml
			driver = new ChromeDriver();
//			driver.get("http://google.com");
//		}else if(loadData(browserKey).equalsIgnoreCase("IE")){
		}else if(browserKey.equalsIgnoreCase("IE")){
			driver =new InternetExplorerDriver();
//			driver.get("http://facebook.com");
//		}else if(loadData(browserKey).equalsIgnoreCase("Firefox")){
		}else if(browserKey.equalsIgnoreCase("Firefox")){
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String path = "./log4j.properties";
		PropertyConfigurator.configure(path);
		
	}
	public static boolean verifyText(String locatorKey, String expectedValue) throws Exception {
		String actValue = getElement(locatorKey).getText().trim();
		if(actValue.equalsIgnoreCase(loadData(expectedValue)))
			return true;
		else
			return false;
		
	}
	
	public static boolean isElementPresent(String locatorKey) throws Exception {
		List<WebElement> element = null;
		if(locatorKey.endsWith("_id")) {
			element = driver.findElements(By.id(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElements(By.name(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElements(By.name(loadData(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElements(By.linkText(loadData(locatorKey)));
		} 
		if(element.size()==0)
		return true;
		else
		return false;
		
		
	}
	
	public void waitForElement(int timeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void selectItem(int value, WebElement element) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}
	
	public Integer randomNum() {

		Random r = new Random();
		int rnum = r.nextInt(999999);
		return rnum;
	}
	
	public static void close()
	{
		driver.close();
		driver.quit();
	}

}
