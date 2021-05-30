package org.kaamchha.pageobjects.login;


import org.kaamchha.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
	
	public LoginPage(WebDriver driver) {
		
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
	
	public void checkInvalidInput() {
		
		invalidInputCheck(pwd, phnumber);
		
	}

}
