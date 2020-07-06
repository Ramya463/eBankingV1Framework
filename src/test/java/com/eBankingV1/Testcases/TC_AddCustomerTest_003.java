package com.eBankingV1.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankingV1.pageobjects.AddCustomerPage;
import com.eBankingV1.pageobjects.loginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		loginPage lp=new loginPage(driver);
		lp.setUserName(userId);
		logger.info("User Name Provided");
		lp.setPassword(password);
		logger.info("Password Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details....");
		
		addcust.custName("Ramya");
		addcust.custgender("female");
		Thread.sleep(10000);
		//addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("validation started....");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	

}
