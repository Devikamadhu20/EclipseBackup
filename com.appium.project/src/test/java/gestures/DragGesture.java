package gestures;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class DragGesture {
	
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
		
				   driver.findElement(AppiumBy.accessibilityId("Views")).click();
				   driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
				   
		           WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
			
		((JavascriptExecutor)driver).executeScript("mobile:dragGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),"endX",731,"endY",1196));
		
//		((JavascriptExecutor)driver).executeScript("mobile:dragGesture",ImmutableMap.of("startX",215,"startY",590
//				,"endX",,"endY",1024,"speed",5000));
        
//		String actText=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).getText();
//		String expText = "Sample menu";
		
	//assertEquals(actText, expText);
		
}

}
