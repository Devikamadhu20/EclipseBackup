package com.news18.objectrepo;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Read_IPL2025Page {
	
	//Rule 1
		AppiumDriver driver;
		
		//Rule 3: Initialization
		public Read_IPL2025Page(AppiumDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
		}
		
		//Rule 2: Declaration

}
