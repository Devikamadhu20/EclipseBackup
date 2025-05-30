package com.appium.project.test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {
	public static void main(String[] args) throws Throwable, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "realme 12 Pro 5G");
		dc.setCapability("UDID", "f3a09c5c");
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage","com.miui.calculator" );
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL u=new URI("http://localhost:4723").toURL();
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		System.out.println("App Launched");
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.miui.calculator:id/btn_4_s\")")).click();
		driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_plus_s")).click();
		driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_3_s")).click();
		System.out.println(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.miui.calculator:id/expression\")")).getText());
		System.out.println(driver.findElement(AppiumBy.className("android.widget.TextView")).getText());
	}

}
