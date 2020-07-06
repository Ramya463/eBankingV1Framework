package com.eBankingV1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpwd;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement linkLogout;
	
	public void setUserName(String Uname) {
		
		txtusername.sendKeys(Uname);
	}
	
    public void setPassword(String Pwd) {
		
		txtpwd.sendKeys(Pwd);
	}
    
    public void clickSubmit(){
		btnLogin.click();
		
	}
    
    public void clickLogout(){
		linkLogout.click();
		
	}
}
