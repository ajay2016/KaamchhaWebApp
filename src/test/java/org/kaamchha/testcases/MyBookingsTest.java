package org.kaamchha.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.kaamchha.base.BaseTest;
import org.kaamchha.pageobjects.dashboard.MyBookingsPage;

import org.kaamchha.utilities.DataUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MyBookingsTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void MyBookings(Hashtable<String, String> data) throws IOException {
		
		ExtentTest test = BaseTest.getLog();
		if (!DataUtil.isRunnable("MyBookings") || data.get("Runmode").equals("N")) {

			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		 test.log(Status.INFO, "Opening a browser " + data.get("Browser"));
		// opening chrome browser
		openBrowser(data.get("Browser"));

		// Navigate to given URL
		test.log(Status.INFO, "Navigate to " + prop.getProperty("appurl"));
		navigate("appurl");
		
		//Clicking on My Account
		test.log(Status.INFO, "Clicking on My Account");
		MyBookingsPage book = new MyBookingsPage(driver);
		book.clickonMyAccount();
		
		//Clicking on Login
		test.log(Status.INFO, "Clicking on Login");
		book.clickonLogin();
		
		//Enter Phone Number
		test.log(Status.INFO, "Entering Phone Number");
		book.enterPhoneNumber(data.get("PhoneNumber"));
		
		//Enter Password
		test.log(Status.INFO, "Enter Password");
		book.enterPassword(data.get("Password"));
		
		//Clicking on Login Button
		test.log(Status.INFO, "Clicking on Login Button");
		book.clickonLoginButton();
		
		//Checking Profile Name
		test.log(Status.INFO, "Checking Profile Name");
		String name = book.getProfileName();
		Assert.assertEquals(name, data.get("Profile Text"));
		
		
		//Click on My Bookings
		test.log(Status.INFO, "Click on My Bookings");		
		book.clickBookings();
		
		//Checking  Booked Service Provider
		test.log(Status.INFO, "Checking  Booked Service Provider");
		for(int i = 0; i < book.BookedProvider.size(); i++) {
			
			String ProviderName = data.get("Service Provider");
			if(ProviderName.equalsIgnoreCase(book.BookedProvider.get(i).getText())) {
				System.out.println(book.BookedProvider.get(i).getText());
				//book.clickRateUser();
				break;
			}
			
		}
		
		// Checking Service provider Page
		test.log(Status.INFO, "Checking Service provider Page");
		String providername =book.getText();
		Assert.assertEquals(providername, data.get("Service Provider"));
	}
}
