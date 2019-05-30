package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest 
{
	@Test(priority=3)
	public void testVerifyVersion()
	{
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String expectedVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		LoginPage lp = new LoginPage(driver);
		// verify loginpagetitle
		lp.verifyTitle(loginTitle);
		
		String actualVersion = lp.verifyVersion();	
		//verify version
		Reporter.log("actual version : "+actualVersion, true);
		Reporter.log("expected version : "+expectedVersion, true);
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actualVersion, expectedVersion);
		sa.assertAll();
		Reporter.log("version is matching :", true);
	}
}

