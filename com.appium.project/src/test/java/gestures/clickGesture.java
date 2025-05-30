package gestures;

import java.io.File;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class clickGesture {
		public static void main(String[] args) throws Throwable, Throwable {
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability("platformName", "android");
			dc.setCapability("automationName", "uiautomator2");
			dc.setCapability("deviceName", "realme 12 Pro 5G");
			dc.setCapability("UDID", "f3a09c5c");
			dc.setCapability("ignoreHiddenApiPolicyError", true);
			dc.setCapability("autoGrantPermissions", true);
			dc.setCapability("noReset", true);
			
			File file=new File("./src/test/resources/ApiDemos-debug.apk");
			dc.setCapability("app", file.getAbsolutePath());
			
			dc.setCapability("appPackage","io.appium.android.apis" );
			dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			
			URL u=new URI("http://localhost:4723").toURL();
			
			AppiumDriver driver=new AppiumDriver(u, dc);
			
			System.out.println("app launched");
			
//			WebElement element = driver.findElement(AppiumBy.accessibilityId("App"));
//			
//			//((JavascriptExecutor)driver).executeScript("mobile:clickGesture",ImmutableMap.of("x",572, "y",779));
//			
//			((JavascriptExecutor)driver).executeScript("mobile:clickGesture",ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));

}
}
