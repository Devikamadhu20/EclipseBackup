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

public class PinchGesture {
	
	public static void main(String[] args) throws Throwable, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "realme 12 Pro 5G");
		dc.setCapability("UDID", "f3a09c5c");
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("noReset", true);
		
		dc.setCapability("appPackage","com.google.android.apps.maps" );
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		URL u=new URI("http://localhost:4723").toURL();
		
		AppiumDriver driver=new AppiumDriver(u, dc);
		
		System.out.println("app launched");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 WebElement element = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/layers_fab_button"));
			
		
		((JavascriptExecutor)driver).executeScript("mobile:pinchOpenGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),"percent",0.75));
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("mobile:pinchCloseGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),"percent",0.50));
		
	}

}
