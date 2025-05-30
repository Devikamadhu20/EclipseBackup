package gestures;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class DoubleClickGesture {
	
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
		
		AppiumDriver driver=new AppiumDriver(u, dc);
		
		System.out.println("app launched");
		
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.miui.calculator:id/btn_4_s\")"));
		
		((JavascriptExecutor)driver).executeScript("mobile:doubleClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
		
		
		

}
}