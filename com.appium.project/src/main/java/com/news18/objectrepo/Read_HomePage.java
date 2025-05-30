package com.news18.objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Read_HomePage {
	//Rule 1
	AppiumDriver driver;
	
	//Rule 3: Initialization
	public Read_HomePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
	}
	
	//Rule 2: Declaration
	@AndroidFindBy(className  = "android.widget.CheckBox")
	private WebElement saveBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IPL 2025\"]")
	private WebElement iplBtn;

	
	
	//Rule 4: Encapsulation
	
	public AppiumDriver getDriver() {
		return driver;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIplBtn() {
		return iplBtn;
	}
	
	

}
