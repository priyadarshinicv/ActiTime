package com.actitime.tests;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=1)
	public void testValidLoginLogout() 
	{
		String user= ExcelData.getData(file_path, "TC01", 1, 0);
		String pass = ExcelData.getData(file_path, "TC01", 1, 1);
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String entertTimeTrackTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		LoginPage lp= new LoginPage(driver);
		EnterTimeTrackPage ep= new EnterTimeTrackPage(driver);
			
		//verify loginTitle
		lp.verifyTitle(loginTitle);
		
		//enter valid username
		Reporter.log("valid username :"+user, true);
		lp.enterUsername(user);
		
		//enter valid password
		Reporter.log("valid password : "+pass, true);
		lp.enterPassword(pass);
		
		//click on login
		lp.clickOnLogin();
		
		//verify entertimetrackpage
		lp.verifyTitle(entertTimeTrackTitle);
		
		//click on logout
		ep.clickOnLogout();
		
		//verify loginpage
		lp.verifyTitle(loginTitle);
	}
	
}

