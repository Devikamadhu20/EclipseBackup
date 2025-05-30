package gestures;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SwipeGesture {
	
	public static void main(String[] args) throws Throwable, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "realme 12 Pro 5G");
		dc.setCapability("UDID", "f3a09c5c");
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		
		dc.setCapability("appPackage","io.appium.android.apis" );
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL u=new URI("http://localhost:4723").toURL();
		
		AppiumDriver driver=new AppiumDriver(u, dc);
		
		System.out.println("app launched");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		 driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Photos\")")).click();
		 WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
			
		
//		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",ImmutableMap.of("left",100,"top",200,"height",100,"width",200,
//				"direction","right","percent",0.90));
		
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),"direction","left","percent",1));
		
	}

}
