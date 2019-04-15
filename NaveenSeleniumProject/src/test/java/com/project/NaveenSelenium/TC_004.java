package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_004 extends BasePage{

  @BeforeMethod(groups= {"regression","smoke","sanity"})
  @Parameters("browser") //Taking parameter from testng.xml
  public void startProcess(String btype) throws Exception // Passing parameter to the method
  {
	  openBrowser(btype);
	  navigate("amazonurl");
  }
  
  @Test(groups= {"regression","smoke","sanity"})
  public void amazon() throws Exception 
  {
	  System.out.println("amazon1 :"+Thread.currentThread().getName());
	  type("amazonsearchbox_id", "textvalue");
	  click("amazonsearchbutton_xpath");
  }

  
  @AfterMethod(groups= {"regression","smoke","sanity"})
  public void endProcess()
  {
	  close();
  }

}
