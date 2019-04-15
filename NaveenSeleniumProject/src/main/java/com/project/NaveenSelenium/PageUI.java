package com.project.NaveenSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUI extends BasePage{
	
	//Login
	
	@FindBy(linkText="Sign in") WebElement signIn;
	@FindBy(id="email") WebElement customerEmail;
	@FindBy(id="passwd") WebElement customerPassword;
	@FindBy(id="SubmitLogin") WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement getErrorMessage;
	
	//Registration
	
	@FindBy(id="email_create") WebElement CustEmail;
	@FindBy(id="SubmitCreate") WebElement SubmitCreate;
	@FindBy(id="id_gender1") WebElement MrRadioButton;
	@FindBy(id="customer_firstname") WebElement CustomerFirstname;
	@FindBy(id="customer_lastname") WebElement CustomerLastname;
	@FindBy(id="passwd") WebElement UserPassword;
	@FindBy(id="days") WebElement DOB_Days;
	@FindBy(id="months") WebElement DOB_Months;
	@FindBy(id="years") WebElement DOB_Years;
	@FindBy(id="company") WebElement UserCompany;
	@FindBy(id="address1") WebElement UserAddress;
	@FindBy(id="address2") WebElement UserAddress2;
	@FindBy(id="city") WebElement UserCity;
	@FindBy(id="id_state") WebElement UserState;
	@FindBy(id="postcode") WebElement PostCode;
	@FindBy(id="id_country") WebElement UserCountry;
	@FindBy(id="other") WebElement AdditionalInformation;
	@FindBy(id="phone") WebElement HomePhone;
	@FindBy(id="phone_mobile") WebElement MobilePhone;
	@FindBy(id="alias") WebElement ReferAddress;
	@FindBy(id="submitAccount") WebElement SubmitAccount;

	public PageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(driver, PageUI.class);
	}

	public void login() {
		signIn.click();
		customerEmail.sendKeys("qatest@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public void customerRegistration() throws Exception {
		
		signIn.click();
		CustEmail.sendKeys(loadData("fname")+loadData("lname")+randomNum()+loadData("domain"));
		System.out.println(CustEmail.getAttribute("value"));
		SubmitCreate.click();
		waitForElement(60, MrRadioButton);
//		Thread.sleep(5000);
		MrRadioButton.click();
		CustomerFirstname.sendKeys("vinay");
		CustomerLastname.sendKeys("kumar");
		UserPassword.sendKeys("abc123");
		selectItem(1, DOB_Days);
		selectItem(1, DOB_Months);
		selectItem(3, DOB_Years);
//		DOB_Days.sendKeys("1");
//		DOB_Months.sendKeys("April");
//		DOB_Years.sendKeys("2018");
		UserCompany.sendKeys("lenovo");
		UserAddress.sendKeys("mgroad");
		UserCity.sendKeys("Bangalore");
		UserState.sendKeys("California");
		PostCode.sendKeys("12345");
		UserCountry.sendKeys("United States");
		MobilePhone.sendKeys("1234567890");
		SubmitAccount.click();
		
	}
	

	public String verifyError() {
		return getErrorMessage.getText();
	}





}

