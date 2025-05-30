package drivers;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Server {
	
	public static void main(String[] args) throws Throwable, Throwable {
		
		File f = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		System.out.println("service started");
			
				
		UiAutomator2Options op = new UiAutomator2Options();
		op.setPlatformName("android");
		op.setAutomationName("uiautomator2");
		op.setDeviceName("realme 12 Pro 5G");
		op.setUdid("f3a09c5c");
		op.setIgnoreHiddenApiPolicyError(true);
		op.setAutoGrantPermissions(true);
		
		
        URL u=new URI("http://localhost:4723").toURL();
        
        AndroidDriver driver=new AndroidDriver(u, op);
        
       service.stop();
       
       System.out.println("service stopped");
	}

}
