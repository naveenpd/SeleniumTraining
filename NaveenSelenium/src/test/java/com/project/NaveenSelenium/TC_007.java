package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_007 extends BasePage{
	
	PageUI page;

  @BeforeMethod
  public void startprocess() throws Exception {
	  openBrowser("chromebrowser");
	  navigate("automationurl");
	  
  }
  
  @Test(enabled=false)
  public void automationLogin() {
	  page = new PageUI(driver);
	  page.login();
	  Assert.assertEquals(page.verifyError(), "Authentication failed.");

  }
  @Test
  public void automationRegistration() throws Exception {
	  
	  page = new PageUI(driver);
	  page.customerRegistration();
	  
  }

  @AfterMethod
  public void endprocess() {
  }

}
