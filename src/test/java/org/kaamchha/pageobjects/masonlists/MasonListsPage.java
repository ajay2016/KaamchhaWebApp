package org.kaamchha.pageobjects.masonlists;

import java.util.List;

import org.kaamchha.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasonListsPage extends BaseTest {
	
	
	
	
	public MasonListsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@href='/en/category/mason']")
	public WebElement mason;
	
	
	@FindBy(xpath = "//*[@class='cr-pagination pt-30']/ul/li")
	public List<WebElement> mlists;
	
	@FindBy(xpath = "//*[@class='col-md-4']")
	public List<WebElement> namelists;
	
	
	public void clickMason() {
		mason.click();
	}
	public void getNameLists() {
		for(int i = 1; i < mlists.size(); i++) {
			
			//System.out.println(namelists.get(i).getText());
			String name = namelists.get(i).getText();
			System.out.println(name);
			scrollToBottom();
			mlists.get(i).click();
			
			
		}
	}

}
