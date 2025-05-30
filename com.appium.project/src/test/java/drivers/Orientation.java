package drivers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Orientation {
	
	public static void main(String[] args) throws Throwable, Throwable {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("realme 12 Pro 5G");
		op.setUdid("f3a09c5c");
		op.setIgnoreHiddenApiPolicyError(true);
		op.setAutoGrantPermissions(true);
		op.setNoReset(true);
		op.setAppPackage("io.appium.android.apis");
		op.setAppActivity("io.appium.android.apis.ApiDemos");
				
        URL u=new URI("http://localhost:4723").toURL();
        
        AndroidDriver driver=new AndroidDriver(u, op);
        
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       
       Thread.sleep(2000);
       
       ScreenOrientation screen = driver.getOrientation();
       
       driver.rotate(screen.LANDSCAPE);
       Thread.sleep(2000);
       driver.rotate(screen.PORTRAIT);
	}

}
