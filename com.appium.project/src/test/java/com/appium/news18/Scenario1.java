package com.appium.news18;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.news18.objectrepo.Read_HomePage;

import Utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class Scenario1 extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
			
			rhp.getSaveBtn().click();
			Thread.sleep(1000);
			rhp.getIplBtn().click();

	}

}
