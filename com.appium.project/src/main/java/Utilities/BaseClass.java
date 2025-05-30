package Utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.news18.objectrepo.Read_HomePage;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public Read_HomePage rhp;
	public AndroidUtility aUtil;

	FileUtility fUtil = new FileUtility();

	@BeforeSuite
	public void startServer() {
		File f = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();

		service.start();
	}
	
	@BeforeClass
	public void launchApp() throws Throwable, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
		dc.setCapability("automationName",fUtil.dataFromPropertiesFile("automationName"));
		dc.setCapability("deviceName", fUtil.dataFromPropertiesFile("deviceName"));
		dc.setCapability("Udid", fUtil.dataFromPropertiesFile("Udid"));
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage",fUtil.dataFromPropertiesFile("appPackage"));
		dc.setCapability("appActivity", fUtil.dataFromPropertiesFile("appActivity"));
		
		URL u=new URI("http://localhost:4723").toURL();
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		System.out.println("------App Opened------");
		}
	
	@BeforeMethod
	public void configBM() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void closeApp( ) throws Throwable {
		aUtil.closeApp(fUtil.dataFromPropertiesFile("packageName"));
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
		
	}
		
		
		
		
		
		
		
		

		
}	
		
	