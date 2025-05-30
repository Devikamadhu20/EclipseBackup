package com.appium.projects;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ReadDataFromPropertiesFile {
	
	public static void main(String[] args) throws Throwable, Throwable {
		
		FileInputStream fis = new FileInputStream("./commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", p.getProperty("platformName"));
		dc.setCapability("automationName", p.getProperty("automationName"));
		dc.setCapability("deviceName", p.getProperty("deviceName"));
		dc.setCapability("Udid", p.getProperty("Udid"));
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage",p.getProperty("appPackage"));
		dc.setCapability("appActivity", p.getProperty("appActivity"));
		
		URL u=new URI("http://localhost:4723").toURL();
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		System.out.println("------App Opened------");
	}

}
