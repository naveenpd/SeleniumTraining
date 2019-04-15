package com.project.NaveenSelenium;

import org.apache.log4j.Logger;

public class TC_001 extends BasePage{
	
	private static final Logger log = Logger.getLogger(TC_001.class.getName());

	public static void main(String[] args) throws Exception {
		
		openBrowser("chromebrowser");
		log.info("Opened the Browser of type:"+loadData("chromebrowser"));
		
		navigate("amazonurl");
		log.info("Navigate to URL :"+loadData("amazonurl"));
		
//		driver.manage().window().maximize();
//		
		type("amazonsearchbox_name","textvalue");
		log.info("Entered the searched Text :"+loadData("textvalue"));
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on Amazon search button");

	}

}
