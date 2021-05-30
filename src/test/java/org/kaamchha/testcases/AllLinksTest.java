package org.kaamchha.testcases;


import java.io.IOException;
import java.util.Hashtable;
import org.kaamchha.base.BaseTest;
import org.kaamchha.pageobjects.links.AllLinksPage;
import org.kaamchha.utilities.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AllLinksTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void LinkTest(Hashtable<String, String> data) throws IOException {
		
		
		ExtentTest test = BaseTest.getLog();
		if (!DataUtil.isRunnable("LinkTest") || data.get("Runmode").equals("N")) {

			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "Opening a browser " + data.get("Browser"));
		// opening chrome browser
		openBrowser(data.get("Browser"));

		// navigate to given url
		test.log(Status.INFO, "Navigate to " + prop.getProperty("appurl"));
		navigate("appurl");
		
		//Checking all links
		test.log(Status.INFO, "Checking all links");
		AllLinksPage link = new AllLinksPage(driver);
		link.LinkTest();
		
	}

}
