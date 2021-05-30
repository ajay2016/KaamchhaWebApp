package org.kaamchha.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBookingsPage {
	
	public MyBookingsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@class='header-accountbox-trigger']")
	public WebElement myaccount;
	
	@FindBy(xpath="//a[@href='/en/auth/login/']")
	public WebElement login;
	
	@FindBy(name="phone_number")
	public WebElement phnumber;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//span[text() = 'Login']")
	public WebElement loginbutton;
	
	@FindBy(xpath = "//*[text() = 'Welcome Anil Karki']")
	public WebElement proftext;
	
	
	
	public void clickonMyAccount() {
		myaccount.click();
	}
	
	public void clickonLogin() {
		login.click();
	}
	
	public void enterPhoneNumber(String data) {
		phnumber.sendKeys(data);
		
	}
	
	public void enterPassword(String data) {
		pwd.sendKeys(data);
	}
	
	public void clickonLoginButton() {
		loginbutton.click();
	}
	
	public String getProfileName() {
		String text = proftext.getText();
		return text;
	}

	//My Bookings
	
	@FindBy(xpath = "//*[@href='/en/auth/dashboard/my-bookings']")
	public WebElement mybookings;
	
	@FindBy(xpath = "//table/tbody/tr/td[3]")
	public List<WebElement> BookedProvider;
	
	@FindBy(xpath = "//a[@href='/en/provider/bablu-singh' and @class ='btn btn-sm btn-success']")
	public WebElement rate;
	
	@FindBy(xpath ="//*[text() ='Bablu Singh']")
	public WebElement spname;
	
	
	public void clickBookings() {
		mybookings.click();
	}
	
	public void clickRateUser() {
		rate.click();
	}
	
	public String getText() {
		String person = spname.getText();
		return person;
		
	}

}
