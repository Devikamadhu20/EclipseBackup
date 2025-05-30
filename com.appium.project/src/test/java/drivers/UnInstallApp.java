package drivers;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class UnInstallApp {
	
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
	        
	        Thread.sleep(2000);
	        driver.terminateApp("com.androidsample.generalstore");
	        driver.removeApp("com.androidsample.generalstore");
	        
	        boolean result = driver.isAppInstalled("com.androidsample.generalstore");
	        
	        System.out.println(result);
    }

}
