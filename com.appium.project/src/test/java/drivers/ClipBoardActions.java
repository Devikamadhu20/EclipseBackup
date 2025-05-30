package drivers;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ClipBoardActions {
	
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
       driver.setClipboardText("Hi Appium");
       
       System.out.println(driver.getClipboardText());
	}
}
