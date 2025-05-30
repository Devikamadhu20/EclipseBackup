package com.appium.projects;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ReadDataFromExcel {
	
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
		
		FileInputStream fisE = new FileInputStream("./testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String cell = row.getCell(1).getStringCellValue();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+cell+"\"));")).click();
		
		String name=row.getCell(2).getStringCellValue();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
