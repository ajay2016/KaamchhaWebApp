package org.kaamchha.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.kaamchha.base.BaseTest;
import org.kaamchha.pageobjects.dashboard.MyBookingsPage;
import org.kaamchha.pageobjects.login.LoginPage;

import org.kaamchha.utilities.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void Login(Hashtable<String, String> data) throws IOException {

		ExtentTest test = BaseTest.getLog();
		// test =ExtentListeners.testReport.get().info("Test Started");

		if (!DataUtil.isRunnable("Login") || data.get("Runmode").equals("N")) {

			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "Opening a browser " + data.get("Browser"));
		// opening chrome browser
		openBrowser(data.get("Browser"));

		// Navigate to given URL
		test.log(Status.INFO, "Navigate to " + prop.getProperty("appurl"));
		navigate("appurl");

		// Clicking on My Account
		test.log(Status.INFO, "Clicking on My Account");
		LoginPage lp = new LoginPage(driver);
		lp.clickonMyAccount();

		// Clicking on Login
		test.log(Status.INFO, "Clicking on Login");
		lp.clickonLogin();

		// Enter Phone Number
		test.log(Status.INFO, "Entering Phone Number");
		lp.enterPhoneNumber(data.get("PhoneNumber"));

		 
		 		 

		// Enter Password
		test.log(Status.INFO, "Enter Password");
		lp.enterPassword(data.get("Password"));

		// Clicking on Login Button
		test.log(Status.INFO, "Clicking on Login Button");
		lp.clickonLoginButton();
		
		//Check for valid input
		test.log(Status.INFO, "Checking for valid input");
		if(data.get("Password").isEmpty()||data.get("PhoneNumber").isEmpty())
		lp.checkInvalidInput();
		  
		// Checking Profile Name
		test.log(Status.INFO, "Checking Profile Name");
		String name = lp.getProfileName();
		Assert.assertEquals(name, data.get("Profile Text"));

	}

}
