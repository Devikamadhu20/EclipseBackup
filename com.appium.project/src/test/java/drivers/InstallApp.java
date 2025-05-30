package drivers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.asynchttpclient.uri.Uri;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class InstallApp {

	public static void main(String[] args) throws Throwable {
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("realme 12 Pro 5G");
		op.setUdid("f3a09c5c");
		op.setIgnoreHiddenApiPolicyError(true);
		op.setAutoGrantPermissions(true);
		
        URL u=new URI("http://localhost:4723").toURL();
        
		AndroidDriver driver=new AndroidDriver(u, op);
		File file=new File("./src/test/resources/General-Store.apk");
		driver.installApp(file.getAbsolutePath());
		boolean result = driver.isAppInstalled("com.androidsample.generalstore");
		
		System.out.println(result);

	}

}
