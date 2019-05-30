package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	private WebElement helpBTN;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement abtYourActiTime;
	
	@FindBy(xpath="//span[contains(text(),'build')]")
	private WebElement buildNumber;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogout()
	{
		logoutBTN.click();
	}
	
	public void clickOnHelp()
	{
		helpBTN.click();
	}
	public void clickOnAbtYourActiTime()
	{
		abtYourActiTime.click();
	}
	
	public String verifyBuild()
	{
		verifyElement(buildNumber);
		String aBuildNumber = buildNumber.getText();
		return aBuildNumber;
	}
}


