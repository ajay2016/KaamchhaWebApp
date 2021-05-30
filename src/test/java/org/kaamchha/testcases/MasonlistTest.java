package org.kaamchha.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.kaamchha.base.BaseTest;
import org.kaamchha.pageobjects.masonlists.MasonListsPage;
import org.kaamchha.utilities.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MasonlistTest extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void MasonLists(Hashtable<String, String> data) throws IOException {

		ExtentTest test = BaseTest.getLog();
		// test =ExtentListeners.testReport.get().info("Test Started");

		if (!DataUtil.isRunnable("MasonLists") || data.get("Runmode").equals("N")) {

			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "Opening a browser " + data.get("Browser"));
		// opening chrome browser
		openBrowser(data.get("Browser"));

		// Navigate to given URL
		test.log(Status.INFO, "Navigate to " + prop.getProperty("appurl"));
		navigate("appurl");
		
		//Click on Mason
		test.log(Status.INFO, "Click on Mason");
		MasonListsPage mpage = new MasonListsPage(driver);
		mpage.clickMason();
		
		//Checking Mason Lists
		test.log(Status.INFO, "Checking Mason Lists");
		mpage.getNameLists();

}
}
