package drivers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class OpenNotificationPanelAndHideThekeyboard {

	public static void main(String[] args) throws Throwable, Throwable {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("realme 12 Pro 5G");
		op.setUdid("f3a09c5c");
		op.setIgnoreHiddenApiPolicyError(true);
		op.setAutoGrantPermissions(true);
		
		
        URL u=new URI("http://localhost:4723").toURL();
        
        AndroidDriver driver=new AndroidDriver(u, op);
        
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       //to open notification panel
       //driver.openNotifications();
       
//       //to hide the keyboard
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).click();
       driver.hideKeyboard();
//       
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

       
       
       
       
       

	}

}
