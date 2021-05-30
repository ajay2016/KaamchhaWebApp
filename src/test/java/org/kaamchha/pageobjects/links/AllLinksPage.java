package org.kaamchha.pageobjects.links;

import java.util.List;

import org.kaamchha.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllLinksPage extends BaseTest{
	
	public  AllLinksPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	

	@FindBy(tagName = "a")
	public List<WebElement> alllinks;

	public void LinkTest() {
		System.out.println("Total links on the page " + alllinks.size());
		for (int i = 0; i < alllinks.size(); i++) {
			WebElement element = alllinks.get(i);
			url = element.getAttribute("href");
			verifyLink(url);

		}

	}
}
