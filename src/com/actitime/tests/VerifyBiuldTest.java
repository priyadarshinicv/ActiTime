package com.actitime.tests;


import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBiuldTest extends BaseTest
{
	@Test(priority=4)
	public void testVerifyBuild()
	{
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String entetTimeTrackTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		String user = ExcelData.getData(file_path, "TC04", 1, 0);
		String pass = ExcelData.getData(file_path, "TC04", 1, 1);
		String expectedBuild = ExcelData.getData(file_path, "TC04", 1, 2);
		
		LoginPage lp =new LoginPage(driver);
		EnterTimeTrackPage ep =new EnterTimeTrackPage(driver);
		// verify loginpagetitle
		lp.verifyTitle(loginTitle);
		
		// enter valid username
		Reporter.log("valid username is :"+user, true);
		lp.enterUsername(user);
		
		// enter valid password
		Reporter.log("valid password: "+pass, true);
		lp.enterPassword(pass);
		
		//click on login
		lp.clickOnLogin();
		
		//verify Entertime track page
		lp.verifyTitle(entetTimeTrackTitle);
		
		//click on help
		ep.clickOnHelp();
		
		//click on about your actitime
		ep.clickOnAbtYourActiTime();
		
		//verify build
		String actualBuild = ep.verifyBuild();
		Reporter.log("actual biuld :"+actualBuild, true);
		Reporter.log("expected build :"+expectedBuild, true);
		
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actualBuild, expectedBuild);
		
		sa.assertAll();
		Reporter.log("build is matching  ", true );
	}
}

