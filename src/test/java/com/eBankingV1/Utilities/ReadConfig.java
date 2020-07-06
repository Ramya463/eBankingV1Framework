package com.eBankingV1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}
		catch(Exception e){
			System.out.println("Exception is"+e.getMessage());
			
		}
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String UserName=pro.getProperty("username");
		return UserName;
	}
	
	public String getPassword() {
		String Password=pro.getProperty("password");
		return Password;
	}
	
	public String getChromePath() {
		String ChromePath=pro.getProperty("chromepath");
		return ChromePath;
	}
	
	public String getiePath() {
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	
	public String getFirefoxPath() {
		String FirefoxPath=pro.getProperty("firefoxpath");
		return FirefoxPath;
	}

}
