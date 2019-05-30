package com.actitime.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

import bsh.This;

public class LoginPage extends BasePage
{
	//declaration
	@FindBy(id="username")
	private WebElement usernameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errorMessage;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME ')]")
	private WebElement version;
	
	//Initialization
	public LoginPage(WebDriver driver)	
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void verifypage(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void enterUsername(String un)
	{
		usernameTB.sendKeys(un);
	}
	
	public void enterPassword(String pw) 
	{
		passwordTB.sendKeys(pw);
	}
	
	public void clickOnLogin()
	{
		loginBTN.click();
	}
	
	public String verifyErrorMessage()
	{
		verifyElement(errorMessage);
		String aErrMSG = errorMessage.getText();
		return aErrMSG;
	}
	
	public String verifyVersion() 
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}
}



