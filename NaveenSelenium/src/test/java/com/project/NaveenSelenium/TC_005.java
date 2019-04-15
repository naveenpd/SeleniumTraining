package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_005 extends BasePage{

  @BeforeMethod(groups= {"regression"})
  @Parameters("browser") //Taking parameter from testng.xml
  public void startProcess(String btype) throws Exception // Passing parameter to the method
  {
	  openBrowser(btype);
	  navigate("googleurl");
  }
  

  @Test(groups= {"regression"})
  public void google() throws Exception 
  {
	  System.out.println("google :"+Thread.currentThread().getName());
//	  type("amazonsearchbox_id", "textvalue");
//	  click("amazonsearchbutton_xpath");
  }
  
  @AfterMethod(groups= {"regression"})
  public void endProcess()
  {
	  close();
  }

}
