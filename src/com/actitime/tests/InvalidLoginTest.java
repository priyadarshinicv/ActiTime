package com.actitime.tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException 
	{
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String expectedErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
		LoginPage lp = new LoginPage(driver);
		
		// verify loginpagetitle
		lp.verifyTitle(loginTitle);
		
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i=1;i<=rc;i++) 
		{
			String user = ExcelData.getData(file_path, "TC02", i, 0);
			String pass = ExcelData.getData(file_path, "TC02", i, 1);
			
			//enter invalid username
			Reporter.log("invalid username : "+user, true);
			lp.enterUsername(user);
			
			//enter invalid password
			Reporter.log("invalid password :"+pass, true);
			lp.enterPassword(pass);
			
			//click on login
			lp.clickOnLogin();
			
			Thread.sleep(1000);
			
			//verify error message
			String actualErrorMessage = lp.verifyErrorMessage();
			Reporter.log("actualErrorMessage : "+actualErrorMessage, true);
			Reporter.log("expectedErrorMessage : "+expectedErrorMessage, true);
			
			Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
			Reporter.log("error message is matching ", true);
		}
	}
}

