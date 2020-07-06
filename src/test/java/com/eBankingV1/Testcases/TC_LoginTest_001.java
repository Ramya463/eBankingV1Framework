package com.eBankingV1.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankingV1.pageobjects.loginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException {
		
		
		logger.info("Url is opened");
		loginPage lp=new loginPage(driver);
		lp.setUserName(userId);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 123 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
