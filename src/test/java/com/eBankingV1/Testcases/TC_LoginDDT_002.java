package com.eBankingV1.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBankingV1.Utilities.XlUtils;
import com.eBankingV1.pageobjects.loginPage;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws InterruptedException {
		
		loginPage lp=new loginPage(driver);
		lp.setUserName(user);
		logger.info("Username Provided");
		lp.setPassword(pwd);
		logger.info("Password Provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
		
	}
	
	public boolean isAlertPresent() {
		
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
		   return false;
		}
		
	
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/eBankingV1/Testdata/LoginData.xlsx";
		
		int rownum=XlUtils.getRowCount(path, "Sheet1");
		int colcount=XlUtils.getCellCount(path, "Sheet1", 1);
		
		String LoginData[][]=new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				LoginData[i-1][j]=XlUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return LoginData;
	}
}
